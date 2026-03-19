package com.tdd.laboratorio_tdd_spring.mapper;

import com.tdd.laboratorio_tdd_spring.dto.UserRequestDto;
import com.tdd.laboratorio_tdd_spring.dto.UserResponseDto;
import com.tdd.laboratorio_tdd_spring.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserResponseDto toResponse(User entity);
    User toEntity(UserRequestDto userRequestDto);
}
