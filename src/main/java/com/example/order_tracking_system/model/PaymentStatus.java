package com.example.order_tracking_system.model;

public enum PaymentStatus {
    UNPAID("Chưa thanh toán"),
    AWAITING_PAYMENT("Chờ thanh toán online"),
    PAID("Đã thanh toán"),
    REFUNDED("Đã hoàn tiền");

    private final String description;

    PaymentStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
