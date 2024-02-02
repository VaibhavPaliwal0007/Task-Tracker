package org.example.tasktrackerbackend.service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.tasktrackerbackend.dto.UserDto;
import org.example.tasktrackerbackend.entity.RolesType;
import org.example.tasktrackerbackend.entity.User;
import org.example.tasktrackerbackend.entity.UserRole;
import org.example.tasktrackerbackend.exception.GlobalExceptionHandler;
import org.example.tasktrackerbackend.repository.UserRepository;
import org.example.tasktrackerbackend.security.jwt.JwtUtils;
import org.example.tasktrackerbackend.security.services.UserDetailsImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import org.springframework.security.core.Authentication;

@Service
@Slf4j
@AllArgsConstructor
public class AuthService {
    private static final String USER_NOT_FOUND_WITH_THE_GIVEN_CREDENTIALS = "User not found with the given credentials";
    UserRepository userRepository;
    JwtUtils jwtUtils;
    AuthenticationManager authenticationManager;

    public void saveUser(User user) {
        this.userRepository.save(user);
    }
    public void register(String email, String password, String username) {
        log.info("User with email {} registered", email);
        User user = new User(username, email, password);

        user.setRoles(
            new HashSet<>(List.of(new UserRole(RolesType.ROLE_USER)))
        );

        this.saveUser(user);
    }

    public String login(UserDto user) {
        log.info("User with email {} logged in", user.getEmail());

        if (!this.userRepository.existsByEmail(user.getEmail())) {
            throw new GlobalExceptionHandler.ResourceNotFoundException(USER_NOT_FOUND_WITH_THE_GIVEN_CREDENTIALS);
        }

       Authentication authentication = authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

       SecurityContextHolder.getContext().setAuthentication(authentication);
       String jwtToken = jwtUtils.generateJwtToken(authentication);

//       UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//       List<String> roles = userDetails.getAuthorities().stream()
//          .map(item -> item.getAuthority())
//          .collect(Collectors.toList());

       return jwtToken;
    }
}
