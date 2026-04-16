package com.example.taskservice.web.controller;

import com.example.taskservice.application.dto.TaskRequest;
import com.example.taskservice.application.usecase.*;
import com.example.taskservice.domain.model.Task;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final CreateTaskUseCase createTaskUseCase;
    private final GetAllTasksUseCase getAllTasksUseCase;
    private final CompleteTaskUseCase completeTaskUseCase;

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody @Valid TaskRequest request) {
        Task task = createTaskUseCase.execute(request.getTitle());
        return ResponseEntity.status(201).body(task);
    }

    @GetMapping
    public List<Task> getAll() {
        return getAllTasksUseCase.execute();
    }

    @PutMapping("/complete")
    public Task complete(@RequestBody TaskRequest request) {
        return completeTaskUseCase.execute(request.getTitle());
    }
}