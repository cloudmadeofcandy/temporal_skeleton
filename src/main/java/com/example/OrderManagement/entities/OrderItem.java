package com.example.OrderManagement.entities;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.bson.types.ObjectId;


@EntityScan
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder

@Document(collection = "order_items")
public class OrderItem {

    @Id
    private ObjectId id;

    @Field("order_item_id")
    int order_item_id;

    @Field("order_id")
    int order_id;

    @Field("product_id")
    int product_id;

    @Field("quantity")
    int quantity;

    @Field("unit_price")
    double unit_price;

}
