package com.tdd.laboratorio_tdd_spring.repository;

import com.tdd.laboratorio_tdd_spring.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void mustSavedSuccessfully() {
        // Arrange
        User user = new User(null, "Integracion", "it@test.com");

        // Act
        User saved = userRepository.save(user);

        // Assert
        assertNotNull(saved.getId());
        assertEquals("Integracion", saved.getName());
    }
}