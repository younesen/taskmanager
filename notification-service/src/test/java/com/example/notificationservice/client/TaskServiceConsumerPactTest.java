package com.example.notificationservice.client;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.*;
import au.com.dius.pact.core.model.V4Pact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PactConsumerTestExt.class)
public class TaskServiceConsumerPactTest {

    @Pact(consumer = "notification-service", provider = "task-service")
    public V4Pact getTaskPact(PactDslWithProvider builder) {

        return builder
                .given("task with id 1 exists")
                .uponReceiving("a request for task 1")
                .path("/api/tasks/1")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body(new au.com.dius.pact.consumer.dsl.PactDslJsonBody()
                        .numberType("id", 1)
                        .stringType("title", "Sample task")
                        .stringType("status", "PENDING"))
                .toPact(V4Pact.class);
    }

    @Test
    @PactTestFor(pactMethod = "getTaskPact")
    void shouldGetTask(MockServer mockServer) {

        RestTemplate restTemplate = new RestTemplate();

        String url = mockServer.getUrl() + "/api/tasks/1";

        TaskDto task = restTemplate.getForObject(url, TaskDto.class);

        assertThat(task.getId()).isEqualTo(1);
        assertThat(task.getTitle()).isEqualTo("Sample task");
        assertThat(task.getStatus()).isEqualTo("PENDING");
    }
}