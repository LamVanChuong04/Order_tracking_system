package com.example.order_tracking_system.Service.IService;

import com.example.order_tracking_system.Service.ImService.InUserService;
import com.example.order_tracking_system.dto.UserDto;
import com.example.order_tracking_system.model.Users;
import com.example.order_tracking_system.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class ImUserService implements InUserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    public ImUserService(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public String createUser(UserDto u) {
        Users user = modelMapper.map(u, Users.class);

        userRepository.save(user);
        return "created user successfully";
    }

    @Override
    public UserDto findUserByEmail(String email) {
        Users user = userRepository.findByEmail(email);
        return modelMapper.map(user, UserDto.class);
    }
}
