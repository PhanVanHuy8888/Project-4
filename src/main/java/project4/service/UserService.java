package project4.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project4.dto.request.*;
import project4.dto.response.UserResponse;
import project4.entity.User;
import project4.mapper.UserMapper;

import project4.repository.UserRepo;

import java.util.HashSet;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserResponse createUser(UserRequest request) {
        if(userRepo.existsByUserName(request.getUserName()))
            throw new RuntimeException("Username already exist");

        User user = userMapper.createUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        return userMapper.toUserResponse(userRepo.save(user));
    }

    public UserResponse updateUser(String id, UserRequest request) {
        User user = userRepo.findById(id).orElseThrow(() ->  new RuntimeException("User not found by id=" + id));
        userMapper.updateUser(user, request);
        user.setRole(request.getRole());
        return  userMapper.toUserResponse(userRepo.save(user));
    }

    public List<UserResponse> getAllUser() {
        return userRepo.findAll().stream().map(userMapper::toUserResponse).toList();
    }

    public UserResponse getUserById(String id) {
        return userMapper.toUserResponse(userRepo.findById(id).orElseThrow(() ->  new RuntimeException("User not found by id=" + id)) );
    }

    public void deleteUser(String id) {
        userRepo.deleteById(id);
    }

    public void deleteAll() {userRepo.deleteAll();}


}
