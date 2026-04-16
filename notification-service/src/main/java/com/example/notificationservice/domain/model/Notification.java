package com.example.notificationservice.domain.model;

public class Notification {

    private Long taskId;
    private String message;

    public Notification(Long taskId, String message) {
        this.taskId = taskId;
        this.message = message;
    }

    public Long getTaskId() {
        return taskId;
    }

    public String getMessage() {
        return message;
    }
}