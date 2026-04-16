package com.example.taskservice.application.usecase;

import com.example.taskservice.domain.model.Task;
import com.example.taskservice.domain.repository.TaskRepository;

import java.util.List;

public class CompleteTaskUseCase {

    private final TaskRepository repository;

    public CompleteTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public Task execute(String title) {

        List<Task> tasks = repository.findAll();

        Task task = tasks.stream()
                .filter(t -> t.getTitle().equals(title))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.complete();

        return repository.save(task);
    }
}