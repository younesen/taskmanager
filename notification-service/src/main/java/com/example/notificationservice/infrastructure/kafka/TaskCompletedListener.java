package com.example.notificationservice.infrastructure.kafka;

import com.example.notificationservice.application.usecase.SendNotificationUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TaskCompletedListener {

    private final SendNotificationUseCase useCase;

    public TaskCompletedListener(SendNotificationUseCase useCase) {
        this.useCase = useCase;
    }

    @KafkaListener(topics = "task-completed", groupId = "notification-group")
    public void handle(TaskCompletedEvent event) {

        log.info("📥 Received event: {}", event);

        useCase.execute(event.taskId(), event.title());
    }
}