package com.example.taskservice.infrastructure.persistence.adapter;

import com.example.taskservice.domain.model.Task;
import com.example.taskservice.infrastructure.persistence.entity.TaskEntity;

public class TaskMapper {

    public static Task toDomain(TaskEntity entity) {
        Task task = new Task(entity.getTitle());
        if (entity.isCompleted()) {
            task.complete();
        }
        return task;
    }

    public static TaskEntity toEntity(Task task) {
        TaskEntity entity = new TaskEntity();
        entity.setTitle(task.getTitle());
        entity.setCompleted(task.isCompleted());
        return entity;
    }
}