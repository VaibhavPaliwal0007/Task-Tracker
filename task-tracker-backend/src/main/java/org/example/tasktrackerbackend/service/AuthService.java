package org.example.tasktrackerbackend.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.tasktrackerbackend.dto.UserDto;
import org.example.tasktrackerbackend.dto.UserResponseDto;
import org.example.tasktrackerbackend.entity.RolesType;
import org.example.tasktrackerbackend.entity.User;
import org.example.tasktrackerbackend.entity.UserRole;
import org.example.tasktrackerbackend.exception.GlobalExceptionHandler;
import org.example.tasktrackerbackend.repository.UserRepository;
import org.example.tasktrackerbackend.security.jwt.JwtUtils;
import org.example.tasktrackerbackend.security.services.UserDetailsImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class AuthService {

  private static final String USER_NOT_FOUND_WITH_THE_GIVEN_CREDENTIALS = "User not found with the given credentials";
  UserRepository userRepository;
  JwtUtils jwtUtils;
  AuthenticationManager authenticationManager;
  PasswordEncoder passwordEncoder;
  UserService userService;

  public void registerUser(UserDto userDto) {
    if (userRepository.existsByUsername(userDto.getUsername())) {
      throw new GlobalExceptionHandler.UserExistsException("User with the given username already exists");
    }

    if (userRepository.existsByEmail(userDto.getEmail())) {
      throw new GlobalExceptionHandler.UserExistsException("User with the given email already exists");
    }

    User user = new User(
        userDto.getUsername(),
        userDto.getEmail(),
        passwordEncoder.encode(userDto.getPassword())
    );

    user.setRoles(Set.of(new UserRole(RolesType.ROLE_USER)));
    userService.saveUser(user);
  }

  public UserResponseDto validateTokenAndFindUser(UserDto user) {
      try {
          Authentication authentication = authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
          );

          if (!authentication.isAuthenticated()) {
              throw new GlobalExceptionHandler.UserUnauthorizedException("User not authorized");
          }

          SecurityContextHolder.getContext().setAuthentication(authentication);

          String token = jwtUtils.generateJwtToken(authentication);
          UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
          List<String> roles = userDetails.getAuthorities().stream()
              .map(item -> item.getAuthority())
              .collect(Collectors.toList());

          return new UserResponseDto(
              token,
              "Bearer",
              userDetails.getId(),
              userDetails.getUsername(),
              userDetails.getEmail(),
              roles
          );
      } catch (Exception e) {
          log.error(USER_NOT_FOUND_WITH_THE_GIVEN_CREDENTIALS);
          throw new GlobalExceptionHandler.ResourceNotFoundException(USER_NOT_FOUND_WITH_THE_GIVEN_CREDENTIALS);
      }
  }
}
