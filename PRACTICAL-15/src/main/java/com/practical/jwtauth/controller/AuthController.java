package com.practical.jwtauth.controller;

import com.practical.jwtauth.dto.LoginRequest;
import com.practical.jwtauth.dto.LoginResponse;
import com.practical.jwtauth.model.AppUser;
import com.practical.jwtauth.repository.AppUserRepository;
import com.practical.jwtauth.security.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final AppUserRepository appUserRepository;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService, AppUserRepository appUserRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.appUserRepository = appUserRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Invalid username or password"));
        }

        AppUser appUser = appUserRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new IllegalStateException("Authenticated user missing in database"));

        String token = jwtService.generateToken(appUser.getUsername(), appUser.getRole().name());
        return ResponseEntity.ok(new LoginResponse(token, appUser.getUsername(), appUser.getRole().name()));
    }
}
