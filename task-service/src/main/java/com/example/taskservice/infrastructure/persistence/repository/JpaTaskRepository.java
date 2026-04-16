package com.example.taskservice.infrastructure.persistence.repository;

import com.example.taskservice.infrastructure.persistence.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> {
}