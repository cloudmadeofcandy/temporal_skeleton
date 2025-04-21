package com.example.OrderManagement.configuration;

import com.example.OrderManagement.controllers.CustomerController;
import com.example.OrderManagement.controllers.OrderController;
import com.example.OrderManagement.controllers.OrderItemController;
import com.example.OrderManagement.repositories.CustomerRepository;
import com.example.OrderManagement.repositories.OrderItemRepository;
import com.example.OrderManagement.repositories.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public CustomerController customerController(CustomerRepository customerRepository) {
        return new CustomerController(customerRepository);
    }

    @Bean
    public OrderController orderController(OrderRepository orderRepository) {
        return new OrderController(orderRepository);
    }

    @Bean
    public OrderItemController orderItemController(OrderItemRepository orderItemRepository) {
        return new OrderItemController(orderItemRepository);
    }

}
