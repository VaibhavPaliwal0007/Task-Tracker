package org.example.tasktrackerbackend.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
  @NotBlank
  private String username;

  @NotBlank
  @Email
  private String email;

  @NotBlank
  @Email
  private String password;
}
