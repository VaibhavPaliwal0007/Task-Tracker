package org.example.tasktrackerbackend.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.tasktrackerbackend.entity.User;
import org.example.tasktrackerbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    public User getCurrentUser(HttpServletRequest request) {
        String userId = request.getHeader("X-USER-ID");
        return userRepository.findById(Long.parseLong(userId)).orElseThrow();
    }

    public Long getCurrentUserId(HttpServletRequest request) {
        String userId = request.getHeader("X-USER-ID");
        return Long.parseLong(userId);
    }
}
