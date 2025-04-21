package com.example.OrderManagement.repositories;

import com.example.OrderManagement.entities.OrderItem;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

@Repository
public interface OrderItemRepository extends MongoRepository<OrderItem, String> {

    @Query("{order_id:'?0'}")
    OrderItem findOrderItemByProductId(String productId);

    @Query("{order_id:'?0'}")
    List<OrderItem> findOrderItemsByOrderId(String orderId);

    OrderItem insert(OrderItem orderItem);

    @Query(value = "{order_id: ?0}", fields = "{'order_id' : 1, 'product_id' : 1}")
    OrderItem findOrderItemByOrder_item_id(String orderItemId);

}
