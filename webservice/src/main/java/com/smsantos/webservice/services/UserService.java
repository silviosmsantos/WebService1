package com.smsantos.webservice.services;

import com.smsantos.webservice.entities.User;
import com.smsantos.webservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    @Autowired //injeção de dependencias
    private UserRepository userRepository;

    public List<User> findAll (){
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);

    }
    public User insert(User user){
        return userRepository.save(user);
    }
}
