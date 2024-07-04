package com.santos.webservice.service;

import com.santos.webservice.entities.User;
import com.santos.webservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findByID (Long id){
        Optional<User> optionalUser = repository.findById(id);
        return optionalUser.get();
    }

}
