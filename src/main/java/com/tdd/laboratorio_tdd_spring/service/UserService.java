package com.tdd.laboratorio_tdd_spring.service;

import com.tdd.laboratorio_tdd_spring.dto.UserRequest;
import com.tdd.laboratorio_tdd_spring.dto.UserResponse;
import com.tdd.laboratorio_tdd_spring.entity.User;
import com.tdd.laboratorio_tdd_spring.mapper.UserMapper;
import com.tdd.laboratorio_tdd_spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse save(UserRequest userRequest){
        return userMapper.toResponse(userRepository.save(userMapper.toEntity(userRequest)));
    }
}
