package org.example.tasktrackerbackend.controller;

import javax.validation.Valid;
import org.example.tasktrackerbackend.dto.UserDto;
import org.example.tasktrackerbackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService = new AuthService();



    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserDto signUpRequest) {
        authService.registerUser(signUpRequest);
        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody UserDto loginRequest) {
        return ResponseEntity.ok(authService.validateTokenAndFindUser(loginRequest));
    }
}
