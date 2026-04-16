package com.example.notificationservice.domain.service;

import com.example.notificationservice.domain.model.Notification;

public interface NotificationService {

    void send(Notification notification);
}