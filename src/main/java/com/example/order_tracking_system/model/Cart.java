package com.example.order_tracking_system.model;

import jakarta.persistence.*;
import org.apache.catalina.User;

import java.math.BigDecimal;
import java.util.ArrayList;

@Entity
@Table(name = "cart_items")
public class Cart extends BaseEntity{

    @Column(name = "total_prices")
    private BigDecimal total;


    // one to one relationship: 1 user -------- 1 cart
    @OneToOne(mappedBy = "user")
    private Users user;

    // one to many relationship: 1 cart ------- n products
    @OneToMany(mappedBy = "products")
    private ArrayList<Products> products;

}
