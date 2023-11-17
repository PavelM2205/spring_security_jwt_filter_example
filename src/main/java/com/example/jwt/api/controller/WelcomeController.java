package com.example.jwt.api.controller;

import com.example.jwt.api.dto.AuthRequestDto;
import com.example.jwt.api.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WelcomeController {

    private final AuthService authService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to service!!!";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> generateToken(@RequestBody AuthRequestDto authRequestDto) {
        return authService.generateToken(authRequestDto);
    }
}
