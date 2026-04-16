package com.example.notificationservice.infrastructure.kafka;

public record TaskCompletedEvent(Long taskId, String title, Long userId) {}