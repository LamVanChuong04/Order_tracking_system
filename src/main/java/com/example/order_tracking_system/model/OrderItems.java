package com.example.order_tracking_system.model;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
public class OrderItems extends BaseEntity{

    // many to one relationship:
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    private Orders order;

    // many to one relationship:
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Products product;

    @Column(name = "quantity_products", nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private BigDecimal priceAtPurchase;
}
