package com.example.order_tracking_system.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Products extends BaseEntity{
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "product_price", nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private int quantity_in_stock;


    // many to one relationship: n product ------- 1 cart
    // khóa ngoại nằm ở bảng nhìu
    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;
}
