package com.example.kcortes.mapper;

import com.example.kcortes.dto.UserRequest;
import com.example.kcortes.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "registrationDate", expression = "java(new java.util.Date())")
    @Mapping(target = "active", constant = "true")
    User mapToUser(UserRequest userRequest);
}
