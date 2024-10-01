package com.learn.Identity_service.service;

import com.learn.Identity_service.dto.request.UserCreationRequest;
import com.learn.Identity_service.dto.response.UserResponse;
import com.learn.Identity_service.entity.User;

import java.util.List;

public interface UserService {

    UserResponse createRequest(UserCreationRequest userRequest);
    List<UserResponse> getAllUser();
    UserResponse getUserById(String id);

}
