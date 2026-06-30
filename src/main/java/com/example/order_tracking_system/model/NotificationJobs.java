package com.example.order_tracking_system.model;

import jakarta.persistence.*;

import javax.print.attribute.standard.MediaSize;

@Entity
@Table(name = "notification_jobs")
public class NotificationJobs extends BaseEntity{

    // 1 order ------------- n notification jobs
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Orders order;

    private String status;

}
