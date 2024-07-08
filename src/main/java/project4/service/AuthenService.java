package project4.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import project4.dto.request.LoginRequest;
import project4.dto.response.LoginResponse;
import project4.dto.response.ResponseData;
import project4.repository.UserRepo;

@Service
@RequiredArgsConstructor
public class AuthenService {
    private final AuthenticationManager authenticationManager;
    private final UserRepo userRepo;

    public LoginResponse authenticate(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userRepo.findByEmail(request.getUsername());
        return LoginResponse.builder()
                .userId(user.getId())
                .build();
    }
}
