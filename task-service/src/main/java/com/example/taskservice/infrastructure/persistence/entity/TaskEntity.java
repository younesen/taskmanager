package com.example.taskservice.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TaskEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private boolean completed;
}