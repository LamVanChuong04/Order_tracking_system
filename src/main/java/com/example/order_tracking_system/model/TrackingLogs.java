package com.example.order_tracking_system.model;


import jakarta.persistence.*;

@Entity
@Table(name = "tracking_logs")
public class TrackingLogs extends BaseEntity{

    // 1 order ---- n logs
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Orders order;

    // 1 user--------- n logs
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users user;

    private String location;
    private String fromStatus;
    private String toStatus;
}
