package com.example.OrderManagement;

import com.example.OrderManagement.controllers.CustomerController;
import com.example.OrderManagement.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderManagementApplication {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerController endpoints;

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementApplication.class, args);
	}

}
