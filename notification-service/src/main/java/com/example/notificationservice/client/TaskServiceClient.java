package com.example.notificationservice.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TaskServiceClient {

    private final RestTemplate restTemplate;

    private final String taskServiceUrl = "http://localhost:8081";

    public TaskServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public TaskDto getTaskById(Long id) {
        String url = taskServiceUrl + "/api/tasks/" + id;
        return restTemplate.getForObject(url, TaskDto.class);
    }
}