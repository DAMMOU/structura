package com.structura.project.core.project.model;

public record RemoveTaskCommand(String projectId, String taskId) {

    public RemoveTaskCommand {
        if (projectId == null) {
            throw new IllegalArgumentException("id must not be null");
        }

        if (taskId == null) {
            throw new IllegalArgumentException("taskId must not be null");
        }
    }
}
