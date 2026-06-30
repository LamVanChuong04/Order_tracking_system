package com.example.order_tracking_system.repository;

import com.example.order_tracking_system.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {
    // find user by email
    Users findByEmail(String email);
}
