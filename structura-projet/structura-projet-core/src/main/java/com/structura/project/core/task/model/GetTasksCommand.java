package com.structura.project.core.task.model;

import java.time.LocalDate;

public record GetTasksCommand(
        String projectId,
        TaskStatus status,
        LocalDate from,
        LocalDate to
) {
}
