package com.example.order_tracking_system.model;

public enum OrderStatus {
    PENDING("Chờ xác nhận"),
    CONFIRMED("Đã xác nhận"),
    PICKING("Đang lấy hàng"),
    SHIPPING("Đang giao hàng"),
    DELIVERED("Giao hàng thành công"),
    FAILED("Giao hàng thất bại"),
    RETURNING("Chuyển hoàn");

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    // Viết luôn logic State Machine vào đây để kiểm tra tính hợp lệ
    public boolean canTransitionTo(OrderStatus nextStatus) {
        return switch (this) {
            case PENDING -> nextStatus == CONFIRMED || nextStatus == FAILED;
            case CONFIRMED -> nextStatus == PICKING || nextStatus == FAILED;
            case PICKING -> nextStatus == SHIPPING || nextStatus == FAILED;
            case SHIPPING -> nextStatus == DELIVERED || nextStatus == FAILED;
            case FAILED -> nextStatus == RETURNING;
            default -> false; // Các trạng thái cuối (DELIVERED, RETURNING) không thể đi tiếp
        };
    }
}