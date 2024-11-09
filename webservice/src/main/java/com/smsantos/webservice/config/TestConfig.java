package com.smsantos.webservice.config;

import com.smsantos.webservice.entities.Category;
import com.smsantos.webservice.entities.Order;
import com.smsantos.webservice.entities.User;
import com.smsantos.webservice.entities.enums.OrderStatus;
import com.smsantos.webservice.repositories.CategoryRepository;
import com.smsantos.webservice.repositories.OrderRepository;
import com.smsantos.webservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Silvio Martins Santos", "smstantos@gmail.com", "88990900000", "12345676");
        User u2 = new User(null, "Joicy Peixoto Dias", "joicy@gmail.com", "88990901111", "1234abcd");
        User u3 = new User(null, "Rodrigo Rodrigues", "rodrigo@gmail.com", "88990902222", "123efgh");
        userRepository.saveAll(Arrays.asList(u1,u2,u3));

        Order order1 = new Order(null, Instant.parse("2024-11-02T15:00:22Z"), OrderStatus.WAITING_PAYMENT,u1);
        Order order2 = new Order(null, Instant.parse("2024-11-03T16:21:22Z"), OrderStatus.PAID,u1);
        Order order3 = new Order(null, Instant.parse("2024-11-03T14:23:22Z"), OrderStatus.SHIPPED,u2);
        Order order4 = new Order(null, Instant.parse("2024-11-04T11:59:20Z"), OrderStatus.DELIVERED,u3);
        Order order5 = new Order(null, Instant.parse("2024-11-04T11:59:20Z"), OrderStatus.CANCELED,u3);
        orderRepository.saveAll(Arrays.asList(order1, order2, order3, order4, order5));


        Category c1 = new Category(null, "Notebooks");
        Category c2 = new Category(null, "Tablets");
        Category c3 = new Category(null, "Monitor");
        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));


    }
}
