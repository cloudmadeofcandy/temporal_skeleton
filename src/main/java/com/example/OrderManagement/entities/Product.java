package com.example.OrderManagement.entities;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@EntityScan
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder

@Document(collection = "products")
public class Product {

    @Id
    @Field("product_id")
    private int product_id;

    @Field("name")
    private String name;

    @Field("price")
    private double price;

    @Field("description")
    private String description;

    @Field("stock_quantity")
    private String stock_quantity;

}
