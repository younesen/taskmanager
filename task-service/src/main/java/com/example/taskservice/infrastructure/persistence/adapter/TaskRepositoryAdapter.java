package com.example.taskservice.infrastructure.persistence.adapter;

import com.example.taskservice.domain.model.Task;
import com.example.taskservice.domain.repository.TaskRepository;
import com.example.taskservice.infrastructure.persistence.repository.JpaTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskRepositoryAdapter implements TaskRepository {

    private final JpaTaskRepository jpaRepository;

    @Override
    public Task save(Task task) {
        return TaskMapper.toDomain(
                jpaRepository.save(TaskMapper.toEntity(task))
        );
    }

    @Override
    public List<Task> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(TaskMapper::toDomain)
                .toList();
    }
}