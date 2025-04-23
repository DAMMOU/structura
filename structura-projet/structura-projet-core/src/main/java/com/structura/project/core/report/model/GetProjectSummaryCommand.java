package com.structura.project.core.report.model;

import com.structura.project.core.task.model.TaskStatus;

import java.time.LocalDateTime;

public record GetProjectSummaryCommand(String triggeredBy, String projectId, TaskStatus status,
                                       LocalDateTime from, LocalDateTime to) {

    public GetProjectSummaryCommand {
        if (from.isAfter(to)) {
            throw new IllegalArgumentException("from must not be after to");
        }
    }

    boolean exportAllStatus() {
        return status == null;
    }

    boolean exportAllDates() {
        return from == null && to == null;
    }
}
