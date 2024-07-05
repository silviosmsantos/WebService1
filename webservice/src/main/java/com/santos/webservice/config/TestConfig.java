package com.santos.webservice.config;

import com.santos.webservice.entities.Category;
import com.santos.webservice.entities.Order;
import com.santos.webservice.entities.User;
import com.santos.webservice.entities.enums.OrderStatus;
import com.santos.webservice.repositories.CategoryRepository;
import com.santos.webservice.repositories.OrderRepository;
import com.santos.webservice.repositories.UserRepository;
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
        User u1 = new User(null, "Silvio Martins Santos","88998071000","silvio@gmail.com","123456");
        User u2 = new User(null, "Joicy Peixoto Dias","88998071001" ,"jane@example.com", "54321");

        Category c1 = new Category(null, "Books");
        Category c2 = new Category(null, "Eletronics");
        Category c3 = new Category(null, "Computers");

        Order o1 = new Order(null, Instant.parse("2024-06-29T15:40:07Z"), OrderStatus.WAITING_PAYMENT,u1);
        Order o2 = new Order(null, Instant.parse("2024-06-30T12:40:07Z"), OrderStatus.PAID,u1);
        Order o3 = new Order(null, Instant.parse("2024-07-04T10:00:07Z"), OrderStatus.PAID,u1);

        Order o4 = new Order(null, Instant.parse("2024-06-30T15:40:07Z"), OrderStatus.PAID,u2);
        Order o5 = new Order(null, Instant.parse("2024-07-01T09:20:07Z"), OrderStatus.PAID,u2);
        //instant.parse() is using ISO 8161 type


        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4,o5));
        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
    }

}
