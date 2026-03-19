package com.tdd.laboratorio_tdd_spring.service;

import com.tdd.laboratorio_tdd_spring.dto.UserRequest;
import com.tdd.laboratorio_tdd_spring.dto.UserResponse;
import com.tdd.laboratorio_tdd_spring.entity.User;
import com.tdd.laboratorio_tdd_spring.mapper.UserMapper;
import com.tdd.laboratorio_tdd_spring.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    private UserService userService;

    @BeforeEach
    void setUp(){
        userService = new UserService(userRepository, userMapper);
    }

    @Test
    public void mustSaveSuccessfully(){
        User userForSave = new User(null, "Name test", "test@gmail.com");
        User userSaved = new User(1L, "Name test", "test@gmail.com");

        UserRequest userRequest = new UserRequest("Name test", "test@gmail.com");
        UserResponse userResponse = new UserResponse(1L, "Name test", "test@gmail.com");

        when(userRepository.save(userForSave)).thenReturn(userSaved);

        UserResponse result = userService.save(userRequest);

        assertNotNull(result.getId());
        assertEquals(result, userResponse);
        verify(userRepository, times(1)).save(userForSave);
    }
}
