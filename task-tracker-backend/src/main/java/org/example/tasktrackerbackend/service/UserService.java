package org.example.tasktrackerbackend.service;

import static java.util.Objects.nonNull;

import jakarta.servlet.http.HttpServletRequest;
import com.amazonaws.util.Base64;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.tasktrackerbackend.entity.Image;
import org.example.tasktrackerbackend.entity.User;
import org.example.tasktrackerbackend.repository.ImageRepository;
import org.example.tasktrackerbackend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ImageRepository imageRepository;
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

  public Image uploadImage(HttpServletRequest request, MultipartFile imageFile) throws RuntimeException {
      try {
          if (nonNull(imageFile)) {
              String filenameExtension = StringUtils.getFilenameExtension(imageFile.getOriginalFilename());
              String userId = request.getHeader("X-USER-ID");
              String filename = "sv-" + userId + "-image" + "." + filenameExtension;
              String imageData = Base64.encodeAsString(imageFile.getBytes());
              Image signFile = Image.newImage(filename, imageData);
              return imageRepository.save(signFile); // for now saving in db only but we can save in s3 as well.
          }
      } catch (Exception e) {
          throw new RuntimeException("Could not upload image: " + e.getMessage());
      }

      return null;
  }
}
