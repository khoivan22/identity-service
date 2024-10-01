package com.learn.Identity_service.mapper;

import com.learn.Identity_service.dto.request.UserCreationRequest;
import com.learn.Identity_service.dto.response.UserResponse;
import com.learn.Identity_service.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserCreationRequest userRequest);

    UserResponse toUserResponse(User user);

    List<UserResponse> toUserResposeList(List<User> users);
}
