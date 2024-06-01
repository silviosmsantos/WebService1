package com.santos.webservice.config;

import com.santos.webservice.entities.User;
import com.santos.webservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
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
        User u1 = new User(null, "Silvio Martins Santos","88998071000","silvio@gmail.com","123456");
        User u2 = new User(null, "Joicy Peixoto Dias","88998071001" ,"jane@example.com", "54321");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
