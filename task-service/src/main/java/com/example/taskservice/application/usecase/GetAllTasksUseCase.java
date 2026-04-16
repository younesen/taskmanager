package com.example.taskservice.application.usecase;

import com.example.taskservice.domain.model.Task;
import com.example.taskservice.domain.repository.TaskRepository;

import java.util.List;

public class GetAllTasksUseCase {

    private final TaskRepository repository;

    public GetAllTasksUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> execute() {
        return repository.findAll();
    }
}

@Service
public class GetTaskByIdUseCase {

    private final TaskRepository taskRepository;

    public GetTaskByIdUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task execute(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }
}