package com.barclays.delivery.controller;

import com.barclays.delivery.Exceptions.ServiceException;
import com.barclays.delivery.modal.Credentials;
import com.barclays.delivery.modal.Items;
import com.barclays.delivery.modal.ResponseTemplate;
import com.barclays.delivery.restClient.StoreDataFetch;
import com.barclays.delivery.service.CredentialManagerService;
import com.google.gson.JsonElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class Controller {

    @Autowired
    StoreDataFetch storeDataFetch;
    @Autowired
    CredentialManagerService credentialManagerService;

    /* Fetch Outlet Data */
    @RequestMapping(value = "/outlets",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)
    public JsonElement getOutletData() {

        return storeDataFetch.getOutletData();

    }

    /* Fetch Items Data */
    @RequestMapping(value = "/items",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)
    public List<Items> getItemsData() {

        return storeDataFetch.getItemsData();

    }

    /* Login api */
    @RequestMapping(value = "/login",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    public ResponseTemplate login(@RequestBody Credentials credentials) {

        com.barclays.delivery.entity.Credentials credentials1 = new com.barclays.delivery.entity.Credentials();

        credentials1.setEmail(credentials.getEmail());
        credentials1.setPassword(credentials.getPassword());

        Optional<com.barclays.delivery.entity.Credentials> result = Optional
                .ofNullable(credentialManagerService.findUser(credentials1));

        if(result.isPresent()){
            return new ResponseTemplate("Login Success", HttpStatus.OK,result);
        }
        return new ResponseTemplate(HttpStatus.NOT_FOUND.toString()+": No Matching Credentials", HttpStatus.NOT_FOUND,null);

    }

    /* Sign up api */
    @RequestMapping(value = "/signUp",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.PUT)
    public ResponseTemplate createUser(@RequestBody Credentials credentials) {

        com.barclays.delivery.entity.Credentials credentials1 = new com.barclays.delivery.entity.Credentials();

        credentials1.setEmail(credentials.getEmail());
        credentials1.setPassword(credentials.getPassword());

        try {
            return new ResponseTemplate(HttpStatus.OK.toString(), HttpStatus.OK,credentialManagerService.saveUser(credentials1));
        }catch (ServiceException serviceException){
            return new ResponseTemplate(HttpStatus.BAD_REQUEST.toString(), HttpStatus.BAD_REQUEST,serviceException.getMessage());
        }

    }
}

