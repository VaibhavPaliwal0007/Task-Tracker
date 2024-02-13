package org.example.tasktrackerbackend.service;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.tasktrackerbackend.dto.TaskDto;
import org.example.tasktrackerbackend.entity.Task;
import org.example.tasktrackerbackend.entity.User;
import org.example.tasktrackerbackend.exception.GlobalExceptionHandler.ResourceNotFoundException;
import org.example.tasktrackerbackend.exception.GlobalExceptionHandler.UserUnauthorizedException;
import org.example.tasktrackerbackend.repository.TaskRepository;
import org.example.tasktrackerbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;
    private UserService userService;
    private UserRepository userRepository;

    public void saveTask(Task task) {
        this.taskRepository.save(task);
    }
    public void createTask(TaskDto taskDTO, HttpServletRequest request) {
        log.info("Creating task: " + taskDTO);
        try {
            User user = userService.getCurrentUser(request);
            Task task = new Task(
                taskDTO.getTitle(),
                taskDTO.getDescription(),
                taskDTO.getDueDate(),
                taskDTO.isCompleted(),
                user
            );

            saveTask(task);
        } catch (Exception e) {
            log.error("Error creating task: " + e.getMessage());

        }
    }

    public TaskDto getTaskById(Long taskId) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);

        if (taskOptional.isEmpty()) {
            throw new ResourceNotFoundException("Task not found with the given id");
        }

        Task task = taskOptional.get();
        return new TaskDto(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.getDueDate(),
            task.isCompleted()
        );
    }

    public List<TaskDto> getAllTasks(HttpServletRequest request) {
        Long userId = userService.getCurrentUserId(request);
        Set<Task> tasks = taskRepository.findByUserId(userId);
        return tasks.stream().map(task -> new TaskDto(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.getDueDate(),
            task.isCompleted()
        )).toList();
    }

    public void updateTask(TaskDto taskDto, HttpServletRequest request) {
        Optional<Task> taskOptional = taskRepository.findById(taskDto.getId());
        Long userId = userService.getCurrentUserId(request);

        if (taskOptional.isEmpty()) {
            throw new ResourceNotFoundException("Task not found with the given id");
        }

        if (!taskOptional.get().getUser().getId().equals(userId)) {
            throw new UserUnauthorizedException("User not authorized to update the task");
        }

        Task task = taskOptional.get();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setDueDate(taskDto.getDueDate());
        task.setCompleted(taskDto.isCompleted());

        saveTask(task);
    }

    public void deleteTask(Long taskId, HttpServletRequest request) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        Long userId = userService.getCurrentUserId(request);

        if (taskOptional.isEmpty()) {
            throw new ResourceNotFoundException("Task not found with the given id");
        }

        if (!taskOptional.get().getUser().getId().equals(userId)) {
            throw new UserUnauthorizedException("User not authorized to update the task");
        }

        taskRepository.delete(taskOptional.get());
    }
}
