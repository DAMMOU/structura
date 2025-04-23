package com.structura.project.core.task.model;

import com.structura.project.core.project.model.Project;

import java.time.LocalDateTime;

public record Task(
        String id,
        String title,
        String description,
        Project project,
        TaskOwner owner,
        String assignedTo,
        TaskStatus status,
        LocalDateTime createdAt
) {

    public Task(String id, String title, String description, Project project, TaskOwner owner, String assignedTo) {
        this(
                id,
                title,
                description,
                project,
                owner,
                assignedTo,
                TaskStatus.TODO,
                LocalDateTime.now()
        );
    }
}
