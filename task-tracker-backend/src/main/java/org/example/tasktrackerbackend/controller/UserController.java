package org.example.tasktrackerbackend.controller;


import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.example.tasktrackerbackend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(maxAge = 3600)
@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class UserController {
    private final UserService userService;

    @PostMapping("/upload-image")
    public ResponseEntity<?> uploadImage(@RequestParam(value = "image", required = true) MultipartFile image, HttpServletRequest request) {
        userService.uploadImage(request, image);
        return ResponseEntity.ok("Image uploaded successfully!");
    }
}
