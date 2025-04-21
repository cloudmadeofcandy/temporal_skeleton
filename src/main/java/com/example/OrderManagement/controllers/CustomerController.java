package com.example.OrderManagement.controllers;


import com.example.OrderManagement.entities.Customer;
import com.example.OrderManagement.repositories.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController (CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/search/customer_id")
    public String getCustomerById(@RequestParam int customer_id) {
        Customer customer = customerRepository.findCustomerByCustomer_id(customer_id);
        if (customer == null) {
            return "Customer not found";
        }
        return customer.toString();
    }

    @GetMapping("/search/name")
    public String getCustomer(@RequestParam String name) {
        Customer customer = customerRepository.findCustomerByName(name);
        if (customer == null) {
            return "Customer not found";
        }
        return customer.toString();
    }

    @GetMapping("/search/address")
    public String searchCustomer(@RequestParam String address) {
        List<Customer> customers = customerRepository.findCustomerByAddressContaining(address);
        if (customers.isEmpty()) {
            return "No customers found at this address";
        }
        StringBuilder result = new StringBuilder();
        for (Customer customer : customers) {
            result.append(customer.toString()).append("\n");
        }
        return String.valueOf(result);
    }

    @GetMapping("/count")
    public String getCustomerCount() {
        long count = customerRepository.count();
        return "Total customers: " + count;
    }

    @PostMapping("/insert")
    public void insert(@RequestBody Customer customer) {
        customerRepository.insert(customer);
    }

    @DeleteMapping("/delete/{customer_id}")
    public void deleteBycustomer_id(@PathVariable int customer_id) {
        System.out.println("Deleting customer with ID: " + customer_id);
        Customer customer = customerRepository.findCustomerByCustomer_id(customer_id);
        if (customer != null) {
            customerRepository.delete(customer);
        }
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Customer customer) {
        customerRepository.delete(customer);
    }

    @PutMapping("/update")
    public void update(@RequestBody Customer customer) {

    }
}
