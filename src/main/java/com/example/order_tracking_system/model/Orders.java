package com.example.order_tracking_system.model;

import jakarta.persistence.*;

import java.util.ArrayList;


@Entity
@Table(name = "orders")
public class Orders extends BaseEntity{

    // many to one relationship: n orders ---------- 1 user
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users user;

    // one to many relationship: 1 order ------- n product
    @OneToMany(mappedBy = "order")
    private ArrayList<OrderItems> orderItems;

    // many to one relationship: n order----------- 1 carriers
    @ManyToOne
    @JoinColumn(name = "carrier_id", referencedColumnName = "id")
    private Carriers carrier;

    // one to many relationship: 1 order ------------- n logs
    @OneToMany(mappedBy = "order")
    private ArrayList<TrackingLogs> trackingLogs;




    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false)
    private PaymentStatus paymentStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;

    @Column(nullable = false, name = "shipping_address")
    private String addressShipping;


    @Column(name = "shipping_province", nullable = false)
    private String shippingProvince;


}
