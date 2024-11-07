package com.smsantos.webservice.config;

import com.smsantos.webservice.entities.User;
import com.smsantos.webservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Rodrigo Rodigues", "rodrigo@gmail.com", "88990900000", "springboot#");
        User u2 = new User(null, "Joicy Peixoto", "joicy@gmail.com", "88999001122", "springboot2#");

        userRepository.saveAll(Arrays.asList(u1,u2));
    }
}
