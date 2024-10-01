package com.learn.Identity_service.mapper;

import com.learn.Identity_service.dto.request.UserCreationRequest;
import com.learn.Identity_service.dto.request.UserUpdateRequest;
import com.learn.Identity_service.dto.response.UserResponse;
import com.learn.Identity_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "roles", ignore = true)
    User toUser(UserCreationRequest userRequest);

    UserResponse toUserResponse(User user);

    List<UserResponse> toUserResposeList(List<User> users);

    @Mapping(target = "roles", ignore = true)
    User toUser(UserUpdateRequest userRequest);

    @Mapping(target = "roles", ignore = true)
    User updateUser(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}
