package com.learn.Identity_service.service.serviceImpl;

import com.learn.Identity_service.dto.request.UserCreationRequest;
import com.learn.Identity_service.dto.response.UserResponse;
import com.learn.Identity_service.entity.User;
import com.learn.Identity_service.exception.AppErrorCode;
import com.learn.Identity_service.exception.AppException;
import com.learn.Identity_service.mapper.UserMapper;
import com.learn.Identity_service.repository.UserRepository;
import com.learn.Identity_service.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createRequest(UserCreationRequest userRequest) {

        if (userRepository.existsByUsername(userRequest.getUsername()))
            throw new AppException(AppErrorCode.USER_EXISTED);

        User user = userMapper.toUser(userRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public List<UserResponse> getAllUser() {
        return userMapper.toUserResposeList(userRepository.findAll());
    }

    @Override
    public UserResponse getUserById(String id) {
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new AppException(AppErrorCode.USER_NOT_FOUND)));
    }
}
