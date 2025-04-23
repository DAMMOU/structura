package com.structura.project.core.task.model;

public record CreateTaskCommand(
        String id,
        String title,
        String description,
        TaskOwner owner,
        String assignedTo
) {
}
