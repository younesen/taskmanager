package com.example.taskservice;

import au.com.dius.pact.provider.junit5.*;
import au.com.dius.pact.provider.junit5.loader.PactFolder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

@ExtendWith(PactVerificationInvocationContextProvider.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@PactFolder("src/test/resources/pacts")
@Provider("task-service")
@Consumer("notification-service")
@ActiveProfiles("test")
public class TaskServiceProviderPactTest {

    @LocalServerPort
    int port;

    @BeforeEach
    void setup(PactVerificationContext context) {
        context.setTarget(new HttpTestTarget("localhost", port));
    }

    @TestTemplate
    void pactVerificationTestTemplate(PactVerificationContext context) {
        context.verifyInteraction();
    }

    // 👉 Etat défini dans le Pact
    @State("task with id 1 exists")
    public void taskExists() {
        // Ici tu peux mocker ou insérer une task en DB
        System.out.println("State: task exists");
    }
}