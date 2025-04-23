package com.structura.project.core.project.model;

public record DeleteProjectCommand(String projectId) {

    public DeleteProjectCommand {
        if (projectId == null || projectId.isBlank()) {
            throw new IllegalArgumentException("projectId must not be null or blank");
        }
    }
}
