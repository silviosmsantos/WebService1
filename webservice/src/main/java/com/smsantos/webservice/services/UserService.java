package com.smsantos.webservice.services;

import com.smsantos.webservice.entities.User;
import com.smsantos.webservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{

    @Autowired //injeção de dependencias
    private UserRepository userRepository;

    public List<User> findAll (){
        return userRepository.findAll();
    }

}
