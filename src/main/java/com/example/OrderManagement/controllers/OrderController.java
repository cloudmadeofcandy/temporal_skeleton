package com.example.OrderManagement.controllers;

import com.example.OrderManagement.entities.Order;
import com.example.OrderManagement.repositories.OrderRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/")
    public String helloWorld() {
        return "Ping Successful!";
    }

    @GetMapping("/search/order_id")
    public String getOrder(@RequestParam String order_id) {
        return orderRepository.findOrderByOrderId(order_id).toString();
    }

    @GetMapping("/count")
    public String getOrderCount() {
        return "Total orders: " + orderRepository.count();
    }

    @PostMapping("/insert")
    public void insert(@RequestBody Order order) {
        orderRepository.insert(order);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Order order) {
        orderRepository.deleteById(order.getId().toString());
    }

}
