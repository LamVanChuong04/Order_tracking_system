package com.example.order_tracking_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.Order;

import java.math.BigDecimal;
import java.util.ArrayList;

@Entity
@Table(name = "carriers")
public class Carriers  extends BaseEntity {
    @Column(name = "carrier_name", nullable = false)
    private String name;

    @Column(name = "base_fee")
    private BigDecimal baseFee;

    // one to many relationship:
    @OneToMany(mappedBy = "orders")
    private ArrayList<Orders> orders;
}
