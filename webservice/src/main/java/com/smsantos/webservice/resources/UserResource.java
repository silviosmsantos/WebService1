package com.smsantos.webservice.resources;

import com.smsantos.webservice.entities.User;
import com.smsantos.webservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<User>> findByID(@PathVariable Long id){
        Optional<User> user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    private ResponseEntity<User> insert (@RequestBody User user){
        user = userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }
}
