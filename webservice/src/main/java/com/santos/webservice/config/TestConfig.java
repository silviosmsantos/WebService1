package com.santos.webservice.config;

import com.santos.webservice.entities.Category;
import com.santos.webservice.entities.Order;
import com.santos.webservice.entities.Product;
import com.santos.webservice.entities.User;
import com.santos.webservice.entities.enums.OrderStatus;
import com.santos.webservice.repositories.CategoryRepository;
import com.santos.webservice.repositories.OrderRepository;
import com.santos.webservice.repositories.ProductRepository;
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

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Silvio Martins Santos","88998071000","silvio@gmail.com","123456");
        User u2 = new User(null, "Joicy Peixoto Dias","88998071001" ,"jane@example.com", "54321");

        Category c1 = new Category(null, "Books");
        Category c2 = new Category(null, "Eletronics");
        Category c3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        p1.getCategories().add(c1);
        p2.getCategories().add(c2);
        p2.getCategories().add(c3);
        p3.getCategories().add(c3);
        p4.getCategories().add(c3);
        p5.getCategories().add(c2);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        Order o1 = new Order(null, Instant.parse("2024-06-29T15:40:07Z"), OrderStatus.WAITING_PAYMENT,u1);
        Order o2 = new Order(null, Instant.parse("2024-06-30T12:40:07Z"), OrderStatus.PAID,u1);
        Order o3 = new Order(null, Instant.parse("2024-07-04T10:00:07Z"), OrderStatus.PAID,u1);

        Order o4 = new Order(null, Instant.parse("2024-06-30T15:40:07Z"), OrderStatus.PAID,u2);
        Order o5 = new Order(null, Instant.parse("2024-07-01T09:20:07Z"), OrderStatus.PAID,u2);
        //instant.parse() is using ISO 8161 type


        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4,o5));

    }

}
