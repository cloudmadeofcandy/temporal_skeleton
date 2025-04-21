package com.example.OrderManagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.OrderManagement.entities.OrderItem;
import com.example.OrderManagement.repositories.OrderItemRepository;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/order_item")
public class OrderItemController {

    private final OrderItemRepository orderItemRepository;

    public OrderItemController(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/search/order_id")
    public List<OrderItem> getOrderItemsByOrderId(@RequestParam String order_id) {
        List<OrderItem> orderItem = orderItemRepository.findOrderItemsByOrderId(order_id);
        if (orderItem.isEmpty()) {
            return null;
        }
        return orderItem;
    }

    @GetMapping("/search/order_item_id")
    public OrderItem getOrderItemById(@RequestParam String order_item_id) {
        OrderItem orderItem = orderItemRepository.findOrderItemByOrder_item_id(order_item_id);
        if (orderItem == null) {
            return null;
        }
        return orderItem;
    }

    @PostMapping
    public void insert(@RequestBody OrderItem orderItem) {
        orderItemRepository.insert(orderItem);
    }

    @DeleteMapping
    public void delete(@RequestBody OrderItem orderItem) {
        orderItemRepository.deleteById(orderItem.getId().toString());
    }

}
