package com.learn.Identity_service.controller;

import com.learn.Identity_service.dto.request.UserCreationRequest;
import com.learn.Identity_service.dto.response.ApiResponse;
import com.learn.Identity_service.dto.response.UserResponse;
import com.learn.Identity_service.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;

    @PostMapping
    ApiResponse<UserResponse> createUser(@RequestBody UserCreationRequest userCreationRequest){
        return  ApiResponse.<UserResponse>builder()
                .result(userService.createRequest(userCreationRequest))
                .build();
    }

    @GetMapping
    ApiResponse<List<UserResponse>> getAllUser(){
        return  ApiResponse.<List<UserResponse>>builder()
                .result(userService.getAllUser())
                .build();
    }

    @GetMapping("/{id}")
    ApiResponse<UserResponse> getUserById(@PathVariable String id){

        return  ApiResponse.<UserResponse>builder()
                .result(userService.getUserById(id))
                .build();
    }


}
