package com.barclays.delivery.restClient;

import com.barclays.delivery.modal.Items;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StoreDataFetch {
    @Autowired
    RestTemplate restTemplate;

    /* Pull txt file from url
    * Parse byte array to Json Object
    * Map Json Object to respective Model
    * */
    public JsonElement getOutletData(){

        RequestCallback requestCallback = request -> {
            HttpHeaders headers1 = request
                    .getHeaders();
            headers1
                    .setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM, MediaType.ALL));
        };
        ResponseExtractor<ResponseEntity<byte[]>> responseExtractor = restTemplate.responseEntityExtractor(byte[].class);
        ResponseEntity<byte[]> results = restTemplate
                .execute("https://s3-ap-southeast-1.amazonaws.com/he-public-data/datab79e8b2.txt",
                HttpMethod.GET, requestCallback, responseExtractor);

        String userDetailsBytesToStrings
                = new String(results.getBody(),
                StandardCharsets.UTF_8);
        JsonParser jsonParser = new JsonParser();

        JsonElement jsonOutput
                = jsonParser.parse(
                userDetailsBytesToStrings);

        return jsonOutput;

    }

    public List<Items> getItemsData(){

        RequestCallback requestCallback = request -> {
            HttpHeaders headers1 = request
                    .getHeaders();
            headers1
                    .setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM, MediaType.ALL));
        };
        ResponseExtractor<ResponseEntity<byte[]>> responseExtractor = restTemplate.responseEntityExtractor(byte[].class);
        ResponseEntity<byte[]> results = restTemplate
                .execute("https://s3-ap-southeast-1.amazonaws.com/he-public-data/items22808a8.txt",
                        HttpMethod.GET, requestCallback, responseExtractor);

        String userDetailsBytesToStrings
                = new String(results.getBody(),
                StandardCharsets.UTF_8);
        JsonParser jsonParser = new JsonParser();

        JsonElement jsonOutput
                = jsonParser.parse(
                userDetailsBytesToStrings);

        JsonObject jsonObject =  jsonOutput.getAsJsonObject();
        Items[] items = new Items[0];
        try {
            items = new ObjectMapper().readValue(jsonObject.get("Data").toString(), Items[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return Arrays.stream(items).collect(Collectors.toList());

    }
}
