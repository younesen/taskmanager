package com.example.taskservice.infrastructure.config;

import com.example.taskservice.application.usecase.*;
import com.example.taskservice.domain.repository.TaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CreateTaskUseCase createTaskUseCase(TaskRepository repository) {
        return new CreateTaskUseCase(repository);
    }

    @Bean
    public GetAllTasksUseCase getAllTasksUseCase(TaskRepository repository) {
        return new GetAllTasksUseCase(repository);
    }

    @Bean
    public CompleteTaskUseCase completeTaskUseCase(TaskRepository repository) {
        return new CompleteTaskUseCase(repository);
    }
}