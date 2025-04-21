package com.example.OrderManagement.entities;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;


@EntityScan
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder

@Document(collection = "payments")
public class Payment {

    @Id
    @Field("payment_id")
    int payment_id;

    @Field("order_id")
    int order_id;

    @Field("payment_method")
    String payment_method;

    @Field("amount")
    double amount;

    @Field("payment_status")
    String payment_status;

    @Field("payment_date")
    Date payment_date;

}
