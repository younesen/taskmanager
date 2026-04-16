package com.example.taskservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TaskControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("admin", "admin");
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    @Test
    void fullFlowTest() {

        // 1. Create task (201)
        HttpEntity<String> request = new HttpEntity<>("{\"title\":\"Test Task\"}", headers());

        ResponseEntity<String> response =
                restTemplate.postForEntity("/tasks", request, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        // 2. Get all tasks (200)
        HttpEntity<Void> getRequest = new HttpEntity<>(headers());

        ResponseEntity<String> getResponse =
                restTemplate.exchange("/tasks", HttpMethod.GET, getRequest, String.class);

        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        // 3. Invalid request (400)
        HttpEntity<String> badRequest = new HttpEntity<>("{\"title\":\"\"}", headers());

        ResponseEntity<String> badResponse =
                restTemplate.postForEntity("/tasks", badRequest, String.class);

        assertThat(badResponse.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}

