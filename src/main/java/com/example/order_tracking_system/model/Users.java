package com.example.order_tracking_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users extends BaseEntity {

    @Column(name = "first_name", length = 25)
    private String firstName;
    @Column(name = "last_name", length = 7)
    private String lastName;
    private String email;
    private String password;


    // one to one relationship
    @OneToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;

    // one to many relationship: 1 user ---------- n orders
    @OneToMany(mappedBy = "user")
    private ArrayList<Orders> orders;

    // one to one relationship: 1 user -------------- n logs
    @OneToMany(mappedBy = "user")
    private ArrayList<TrackingLogs> trackingLogs;

}
