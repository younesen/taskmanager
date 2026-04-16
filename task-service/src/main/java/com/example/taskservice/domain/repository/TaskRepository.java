package com.example.taskservice.domain.repository;

import com.example.taskservice.domain.model.Task;

import java.util.List;

public interface TaskRepository {

    Task save(Task task);

    List<Task> findAll();
}