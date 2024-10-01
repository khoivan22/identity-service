package com.learn.Identity_service.mapper;

import com.learn.Identity_service.dto.request.UserCreationRequest;
import com.learn.Identity_service.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User requestToUser(UserCreationRequest userRequest);
}
