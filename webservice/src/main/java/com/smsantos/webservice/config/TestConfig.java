package com.smsantos.webservice.config;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.smsantos.webservice.entities.*;
import com.smsantos.webservice.entities.enums.OrderStatus;
import com.smsantos.webservice.repositories.*;
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

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Silvio Martins Santos", "smsantos@gmail.com", "88990900000", "12345676");
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


        Product p1 = new Product(null, "Samsung Odyssey", "Core i7-13620H, 16GB RAM, 512GB SSD, NVIDIA RTX 3050, 15.6 LED Full HD 144Hz", 5778.00, "http://www.image.com/asudhasoid1231asdq&");
        Product p2 = new Product(null, "Samsung Odyssey 2", "Core i9-13620H, 16GB RAM, 512GB SSD, NVIDIA RTX 4050, 17.0 LED Full HD 144Hz", 6878.00, "http://www.image.com/asudhasoid10910910910");
        Product p3 = new Product(null, "Samsung Tablet 29 grafit", "256GB, 11, WiFi, Câmera Principal 13MP, Câmera Frontal 12MP, UW,", 5719.00, "http://www.image.com/10910910910");
        Product p4 = new Product(null, "Apple iPad Pro", "Wi-Fi de 11 polegadas (Wi-Fi, 512 GB) - Cinzento sideral", 14399.00, "http://www.image.com/a%bbccc0192839181111%%%kappa");
        Product p5 = new Product(null, "Samsung Monitor g30", "24 144Hz 1ms AMD FreeSync Premium", 835.99, "http://www.image.com/a%a901298ahccccas#");

        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        p1.getCategories().add(c1);
        p2.getCategories().add(c1);
        p3.getCategories().add(c2);
        p4.getCategories().add(c2);
        p5.getCategories().add(c3);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        OrderItem oi1 = new OrderItem(order1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(order1, p1, 3, p1.getPrice());
        OrderItem oi3 = new OrderItem(order2, p2, 5, p2.getPrice());
        OrderItem oi4 = new OrderItem(order2, p2, 1, p2.getPrice());
        OrderItem oi5 = new OrderItem(order3, p3, 3, p3.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1,oi2, oi3, oi4, oi5));

        Payment payment1 = new Payment(null, Instant.parse("2024-11-03T18:10:00Z"), order2);
        order2.setPayment(payment1);

        orderRepository.save(order2);
    }
}
