package org.example.tasktrackerbackend.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.example.tasktrackerbackend.dto.TaskDto;
import org.example.tasktrackerbackend.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    ResponseEntity<String> createTask(@RequestBody TaskDto taskDTO, HttpServletRequest request) {
        taskService.createTask(taskDTO, request);
        return ResponseEntity.ok("Task created successfully!");
    }

    @GetMapping("/{id}")
    ResponseEntity<TaskDto> getTaskById(Long id) {
        TaskDto taskDto = taskService.getTaskById(id);
        return ResponseEntity.status(200).body(taskDto);
    }

    @GetMapping("/all")
    ResponseEntity<List<TaskDto>> getAllTasks(HttpServletRequest request) {
        List<TaskDto> taskDtos = taskService.getAllTasks(request);
        return ResponseEntity.status(200).body(taskDtos);
    }

    @PutMapping("/update")
    ResponseEntity<String> updateTask(@RequestBody TaskDto taskDTO, HttpServletRequest request) {
        taskService.updateTask(taskDTO, request);
        return ResponseEntity.ok("Task updated successfully!");
    }

    @DeleteMapping("/delete/{taskId}")
    ResponseEntity<String> deleteTask(Long taskId, HttpServletRequest request) {
        taskService.deleteTask(taskId, request);
        return ResponseEntity.ok("Task deleted successfully!");
    }
}
