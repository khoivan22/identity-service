package com.learn.Identity_service.service.serviceImpl;

import com.learn.Identity_service.dto.request.UserCreationRequest;
import com.learn.Identity_service.entity.User;
import com.learn.Identity_service.exception.UserErrorCode;
import com.learn.Identity_service.exception.UserException;
import com.learn.Identity_service.mapper.UserMapper;
import com.learn.Identity_service.repository.UserRepository;
import com.learn.Identity_service.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    UserMapper userMapper;


    @Override
    public User createRequest(UserCreationRequest userRequest) {

        if(userRepository.existsByUsername(userRequest.getUsername()))
            throw new UserException(UserErrorCode.USER_EXISTED);

        User user = userMapper.requestToUser(userRequest);

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new UserException(UserErrorCode.USER_NOTFOUND));
    }
}
