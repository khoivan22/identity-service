package com.learn.Identity_service.service;

import com.learn.Identity_service.dto.request.UserCreationRequest;
import com.learn.Identity_service.dto.request.UserUpdateRequest;
import com.learn.Identity_service.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserCreationRequest userRequest);

    List<UserResponse> getAllUser();

    UserResponse getUserById(String id);

    UserResponse updateUser(UserUpdateRequest request);

    UserResponse getInfo();

}
