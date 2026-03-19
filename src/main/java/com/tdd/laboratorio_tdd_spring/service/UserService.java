package com.tdd.laboratorio_tdd_spring.service;

import com.tdd.laboratorio_tdd_spring.dto.UserRequestDto;
import com.tdd.laboratorio_tdd_spring.dto.UserResponseDto;
import com.tdd.laboratorio_tdd_spring.exception.EmailIncorrectException;
import com.tdd.laboratorio_tdd_spring.mapper.UserMapper;
import com.tdd.laboratorio_tdd_spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private static final Pattern EMAIL_PATTERN = Pattern.compile("[A-Za-z0-9+_.-]+@(.+)$");

    public UserResponseDto save(UserRequestDto userRequestDto){

        if (userRequestDto.getEmail() == null || !EMAIL_PATTERN.matcher(userRequestDto.getEmail()).matches()){
            throw new EmailIncorrectException();
        }

        return userMapper.toResponse(userRepository.save(userMapper.toEntity(userRequestDto)));
    }
}
