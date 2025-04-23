package com.structura.project.core.project.model;


public record AddTaskToProjectCommand(String projectId, String title, String description, TaskOwner owner, ProjectMember assignedTo) {
    public AddTaskToProjectCommand {
        if (projectId == null) {
            throw new IllegalArgumentException("projectId must not be null");
        }

        if (owner == null) {
            throw new IllegalArgumentException("owner must not be null");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title must not be null or blank");
        }
    }
}
