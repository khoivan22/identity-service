package com.learn.Identity_service.service;

import com.learn.Identity_service.dto.request.UserCreationRequest;
import com.learn.Identity_service.entity.User;

import java.util.List;

public interface UserService {

    User createRequest(UserCreationRequest userRequest);
    List<User> getAllUser();
    User getUserById(String id);

}
