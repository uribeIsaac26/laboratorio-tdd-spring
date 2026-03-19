package com.tdd.laboratorio_tdd_spring.repository;

import com.tdd.laboratorio_tdd_spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
