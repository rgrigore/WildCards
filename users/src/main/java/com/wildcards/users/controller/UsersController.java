package com.wildcards.users.controller;

import com.wildcards.users.model.LoginRequestDTO;
import com.wildcards.users.model.LoginResponseDTO;
import com.wildcards.users.model.RegisterRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UsersController {
    private final UsersService service;

    @PostMapping("/register")
    public boolean register(RegisterRequestDTO requestDTO) {
        return service.register(requestDTO.getEmail(), requestDTO.getUsername(), requestDTO.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO login(LoginRequestDTO requestDTO) {
        return service.login(requestDTO.getEmail(), requestDTO.getPassword());
    }
}
