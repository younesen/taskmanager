package com.example.taskservice.application.usecase;

import com.example.taskservice.domain.model.Task;
import com.example.taskservice.domain.repository.TaskRepository;

public class CreateTaskUseCase {

    private final TaskRepository repository;

    public CreateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public Task execute(String title) {
        Task task = new Task(title);
        return repository.save(task);
    }
}