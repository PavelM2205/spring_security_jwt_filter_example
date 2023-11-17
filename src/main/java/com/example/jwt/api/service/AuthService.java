package com.example.jwt.api.service;

import com.example.jwt.api.dto.AuthRequestDto;
import com.example.jwt.api.dto.JwtResponseDto;
import com.example.jwt.api.exception.AppException;
import com.example.jwt.api.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<?> generateToken(AuthRequestDto authRequestDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequestDto.username(),
                            authRequestDto.password()
                    )
            );
        } catch (AuthenticationException exception) {
            return new ResponseEntity<>(new AppException(HttpStatus.UNAUTHORIZED.value(), "Invalid username/password"),
                                                         HttpStatus.UNAUTHORIZED);
        }
        String token = jwtUtil.generateToken(authRequestDto.username());
        return ResponseEntity.ok(new JwtResponseDto(token));
    }
}
