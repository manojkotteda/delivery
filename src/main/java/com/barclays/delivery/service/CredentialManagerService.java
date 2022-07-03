package com.barclays.delivery.service;

import com.barclays.delivery.Exceptions.ServiceException;
import com.barclays.delivery.entity.Credentials;
import com.barclays.delivery.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CredentialManagerService {
    @Autowired
    UserRepo userRepo;

    public Credentials saveUser(Credentials credentials) throws ServiceException{
        if(Optional.ofNullable(userRepo.findByEmail(credentials.getEmail())).isPresent()){
            throw new ServiceException("User with this EmailId already exists");
        }
        return userRepo.saveAndFlush(credentials);
    }

    public Credentials findUser(Credentials credentials){
        return userRepo.findByEmailAndPassword(credentials.getEmail(),credentials.getPassword());
    }

}
