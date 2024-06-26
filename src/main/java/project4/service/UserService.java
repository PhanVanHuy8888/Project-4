package project4.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project4.dto.request.*;
import project4.dto.response.UserResponse;
import project4.entity.Role;
import project4.entity.User;
import project4.mapper.UserMapper;

import project4.repository.RoleRepo;
import project4.repository.UserRepo;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserResponse createUser(UserRequest request) {
        if(userRepo.existsByUserName(request.getUserName()))
            throw new RuntimeException("Username already exist");

        User user = userMapper.createUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setCreateTime(new Date());
        Set<Role> roles = new HashSet<>();
        if(request.getRoles() == null || request.getRoles().isEmpty()){
            Role defautRole = roleRepo.findByName("USER");
            if(defautRole != null ) {
                roles.add(defautRole);
            }
        }else {
            for (String roleName : request.getRoles()){
                Role role = roleRepo.findByName(roleName);
                if(role != null) roles.add(role);
            }
        }
        user.setRoles(roles);
        return userMapper.toUserResponse(userRepo.save(user));
    }

    @PreAuthorize("hasRole('ADMIN')")
    public UserResponse updateUser(String id, UserRequest request) {
        User user = userRepo.findById(id).orElseThrow(() ->  new RuntimeException("User not found by id=" + id));
        userMapper.updateUser(user, request);
        var roles = roleRepo.findAllById(request.getRoles());
        user.setRoles(new HashSet<>(roles));
        return  userMapper.toUserResponse(userRepo.save(user));
    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponse> getAllUser() {
        return userRepo.findAll().stream().map(userMapper::toUserResponse).toList();
    }

    public UserResponse getUserById(String id) {
        return userMapper.toUserResponse(userRepo.findById(id).orElseThrow(() ->  new RuntimeException("User not found by id=" + id)) );
    }

    public UserResponse getUserByName(String username) {
        return userMapper.toUserResponse(userRepo.findByUserName(username));
    }

    public void deleteUser(String id) {
        userRepo.deleteById(id);
    }

    public void deleteAll() {userRepo.deleteAll();}


}
