package com.tdd.laboratorio_tdd_spring.mapper;

import com.tdd.laboratorio_tdd_spring.dto.UserRequest;
import com.tdd.laboratorio_tdd_spring.dto.UserResponse;
import com.tdd.laboratorio_tdd_spring.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserResponse toResponse(User entity);
    User toEntity(UserRequest userRequest);
}
