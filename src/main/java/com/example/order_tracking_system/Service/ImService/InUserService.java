package com.example.order_tracking_system.Service.ImService;

import com.example.order_tracking_system.dto.UserDto;

public interface InUserService {
    // creat user
    public String createUser(UserDto user);
    public UserDto findUserByEmail(String email);
}
