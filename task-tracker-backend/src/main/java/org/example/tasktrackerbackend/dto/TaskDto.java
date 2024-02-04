package org.example.tasktrackerbackend.dto;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
  private Long id;

  @NotBlank
  private String title;

  @NotBlank
  private String description;

  @NotBlank
  private LocalDate dueDate;

  private boolean completed = false;

  public TaskDto(String title, String description, LocalDate dueDate, boolean completed) {
    this.title = title;
    this.description = description;
    this.dueDate = dueDate;
    this.completed = completed;
  }
}
