package com.smsantos.webservice.resources;

import com.smsantos.webservice.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User user = new User(1L, "Silvio Martins Santos", "silviosmsantos@gmail.com", "(88) 9 98071000", "webservice#");
        return ResponseEntity.ok().body(user);
    }
}
