package com.example.order_tracking_system.controller;

import com.example.order_tracking_system.Service.IService.ImUserService;
import com.example.order_tracking_system.Service.IService.KafkaProducerService;
import com.example.order_tracking_system.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final ImUserService imUserService;
    private final KafkaProducerService kafkaProducerService;
    public UserController(ImUserService imUserService, KafkaProducerService kafkaProducerService) {
        this.imUserService = imUserService;
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(imUserService.createUser(userDto));
    }

    @GetMapping("/find")
    public UserDto findUserByEmail(@RequestParam String email) {
        return imUserService.findUserByEmail(email);
    }

    @GetMapping("/publish/{mess}")
    public ResponseEntity<String> sendMessage(@PathVariable String mess) {
        for(int i = 0; i< 100000; i++)
        {
            kafkaProducerService.sendMessage(mess + ": "+ i);
        }
        return new ResponseEntity<>("Send message successfull", HttpStatus.OK);
    }
}
