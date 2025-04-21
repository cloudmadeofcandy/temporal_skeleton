package com.example.OrderManagement.entities;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.bson.types.ObjectId;
import java.util.Date;


@EntityScan
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter

@Document(collection = "orders")
public class Order {

    @Id
    private ObjectId id;

    @Field("order_id")
    int order_id;

    @Field("customer_id")
    int customer_id;

    @Field("status")
    String status;

    @Field("order_date")
    Date order_date;

    public String toString() {
        return this.id + " " + this.order_id + " " + this.customer_id + " " + this.status + " " + this.order_date;
    }

}
