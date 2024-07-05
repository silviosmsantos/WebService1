package com.santos.webservice.service;

import com.santos.webservice.entities.Order;
import com.santos.webservice.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return  orderRepository.findAll();
    }

    public Order findByID(Long id){
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return  optionalOrder.get();
    }
}
