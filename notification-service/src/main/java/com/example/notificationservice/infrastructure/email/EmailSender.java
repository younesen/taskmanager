package com.example.notificationservice.infrastructure.email;

import com.example.notificationservice.domain.model.Notification;
import com.example.notificationservice.domain.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailSender implements NotificationService {

    @Override
    public void send(Notification notification) {

        // Simulation email
        log.info("📧 Sending email for task {}: {}",
                notification.getTaskId(),
                notification.getMessage());
    }
}