package com.santos.webservice.resources;

// recurso web implementado por um rest controller

import com.santos.webservice.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll (){
        User user = new User(1L, "Silvio Martins Santos", "88998071000", "silviosmsantos@gmail.com", "silvioms");
        return ResponseEntity.ok().body(user);
    }
}
