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

public class Shipment {

    @Id
    @Field("shipment_id")
    int shipment_id;

    @Field("order_id")
    int order_id;

    @Field("tracking_number")
    String tracking_number;

    @Field("carrier")
    String carrier;

    @Field("shipment_status")
    String status;

    @Field("shipment_date")
    Date shipment_date;

    @Field("estimated_delivery")
    Date estimated_delivery;
}
