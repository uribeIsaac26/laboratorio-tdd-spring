package com.tdd.laboratorio_tdd_spring.service;

import com.tdd.laboratorio_tdd_spring.dto.UserRequestDto;
import com.tdd.laboratorio_tdd_spring.dto.UserResponseDto;
import com.tdd.laboratorio_tdd_spring.entity.User;
import com.tdd.laboratorio_tdd_spring.exception.EmailIncorrectException;
import com.tdd.laboratorio_tdd_spring.mapper.UserMapper;
import com.tdd.laboratorio_tdd_spring.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
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
        User userForSave = new User(null, "Name test", "test.test@gmail.com");
        User userSaved = new User(1L, "Name test", "test.test@gmail.com");

        UserRequestDto userRequestDto = new UserRequestDto("Name test", "test.test@gmail.com");
        UserResponseDto userResponseDto = new UserResponseDto(1L, "Name test", "test.test@gmail.com");

        when(userRepository.save(userForSave)).thenReturn(userSaved);

        UserResponseDto result = userService.save(userRequestDto);

        assertNotNull(result.getId());
        assertEquals(result, userResponseDto);
        verify(userRepository, times(1)).save(userForSave);
    }

    @Test
    public void saveError_emailIncorrect(){
        UserRequestDto userRequestDto = new UserRequestDto ("Name Test", "test");

        EmailIncorrectException exception = assertThrows(EmailIncorrectException.class, ()->{
            userService.save(userRequestDto);
        });

        assertEquals("El Email tiene un formato incorrecto", exception.getMessage());
    }
}
