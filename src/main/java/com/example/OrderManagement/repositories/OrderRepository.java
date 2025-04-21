package com.example.OrderManagement.repositories;

import com.example.OrderManagement.entities.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

    @Query("{customer_id:'?0'}")
    List<Order> findOrdersByCustomerId(String customerId);

    @Query(value="{status:'?0'}", fields="{'orderId' : 1, 'totalAmount' : 1}")
    List<Order> findByStatus(String status);

    @Query(value = "{status: {$regex: ?0}}")
    List<Order> findOrdersByStatusContaining(String status);

    @Query(value = "{order_id: ?0}", fields = "{'order_id' : 1, 'totalAmount' : 1}")
    Order findOrderByOrderId(@Param("order_id") String order_id);

    Order insert(Order order);

    @Query
    void deleteById(String id);

    public long count();

}
