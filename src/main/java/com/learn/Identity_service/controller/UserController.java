package com.learn.Identity_service.controller;

import com.learn.Identity_service.dto.request.UserCreationRequest;
import com.learn.Identity_service.entity.User;
import com.learn.Identity_service.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;


    @PostMapping
    User createUser(@RequestBody UserCreationRequest userCreationRequest){
        return  userService.createRequest(userCreationRequest);
    }



}
