package com.example.notificationservice.application.usecase;

import com.example.notificationservice.domain.model.Notification;
import com.example.notificationservice.domain.service.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class SendNotificationUseCase {

    private final NotificationService notificationService;

    public SendNotificationUseCase(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void execute(Long taskId, String title) {

        String message = "Task completed: " + title;

        Notification notification = new Notification(taskId, message);

        notificationService.send(notification);
    }
}