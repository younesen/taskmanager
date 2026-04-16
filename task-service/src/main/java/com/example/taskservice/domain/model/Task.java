package com.example.taskservice.domain.model;

import com.example.taskservice.domain.exception.DomainException;

public class Task {

    private final String title;
    private boolean completed;

    public Task(String title) {
        if (title == null || title.isBlank()) {
            throw new DomainException("Title cannot be empty");
        }
        this.title = title;
        this.completed = false;
    }

    public void complete() {
        if (completed) {
            throw new DomainException("Task already completed");
        }
        this.completed = true;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }
}