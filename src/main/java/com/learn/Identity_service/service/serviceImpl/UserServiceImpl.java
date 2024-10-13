package com.learn.Identity_service.service.serviceImpl;

import com.learn.Identity_service.dto.request.UserCreationRequest;
import com.learn.Identity_service.dto.request.UserUpdateRequest;
import com.learn.Identity_service.dto.response.UserResponse;
import com.learn.Identity_service.entity.User;
import com.learn.Identity_service.exception.ErrorCode;
import com.learn.Identity_service.exception.AppException;
import com.learn.Identity_service.mapper.UserMapper;
import com.learn.Identity_service.repository.RoleRepository;
import com.learn.Identity_service.repository.UserRepository;
import com.learn.Identity_service.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    RoleRepository roleRepository;

    @Override
    public UserResponse createUser(UserCreationRequest userRequest) {

        if (userRepository.existsByUsername(userRequest.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(userRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAllById(userRequest.getRoles())));

        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public List<UserResponse> getAllUser() {
        return userMapper.toUserResposeList(userRepository.findAll());
    }

    @Override
    public UserResponse getUserById(String id) {
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND)));
    }

    @Override
    @PostAuthorize("returnObject.username == authentication.name")
    public UserResponse updateUser(UserUpdateRequest request) {

        var user = userRepository.findById(request.getId()).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        user = userMapper.updateUser(user, request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        var roles = roleRepository.findAllById(request.getRoles());
        user.setRoles(new HashSet<>(roles));

        user = userRepository.save(user);

        return userMapper.toUserResponse(user);
    }


    @Override
    public UserResponse getInfo() {

        var auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userRepository.findOneByUsername(username).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        return userMapper.toUserResponse(user);
    }
}
