package com.example.OrderManagement.entities;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.bson.types.ObjectId;

import java.util.List;

@EntityScan
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder

@Document(collection = "customers")
public class Customer {

    @Id
    private ObjectId id;

//    @Id
    @Field("customer_id")
    int customer_id;

    @Field("name")
    String name;

    @Field("email")
    String email;

    @Field("phone")
    String phone;

    @Field("address")
    String address;

    @Field("list_credit_card")
    List<CreditCard> list_credit_card;

    private class CreditCard {
        String cardNumber;
        String cardType;
        String expirationDate;
    }

    public String toString() {
        return this.customer_id + " " + this.name + " " + this.email + " " + this.phone + " " + this.address;
    }
}
