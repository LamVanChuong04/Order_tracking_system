package com.example.order_tracking_system.controller;

import com.example.order_tracking_system.Service.IService.ImUserService;
import com.example.order_tracking_system.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final ImUserService imUserService;
    public UserController(ImUserService imUserService) {
        this.imUserService = imUserService;
    }

    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(imUserService.createUser(userDto));
    }

    @GetMapping("/find")
    public UserDto findUserByEmail(@RequestParam String email) {
        return imUserService.findUserByEmail(email);
    }
}
