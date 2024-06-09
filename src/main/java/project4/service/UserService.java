package project4.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project4.dto.request.*;
import project4.dto.response.UserResponse;
import project4.entity.User;
import project4.mapper.UserMapper;
import project4.repository.UserRepo;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserMapper userMapper;

    public UserResponse createUser(UserRequest request) {
        if(userRepo.existsByUserName(request.getUserName()))
            throw new RuntimeException("username already exist");

        User user = userMapper.createUser(request);
        return userMapper.toUserResponse(userRepo.save(user));
    }

    public List<UserResponse> getAllUser() {

        return userRepo.findAll().stream().map(userMapper::toUserResponse).toList();
    }

}
