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
        User u1 = new User(null, "Silvio Martins Santos", "smstantos@gmail.com", "88990900000", "12345676");
        User u2 = new User(null, "Joicy Peixoto Dias", "joicy@gmail.com", "88990901111", "1234abcd");
        User u3 = new User(null, "Rodrigo Rodrigues", "rodrigo@gmail.com", "88990902222", "123efgh");

        userRepository.saveAll(Arrays.asList(u1,u2,u3));
    }
}
