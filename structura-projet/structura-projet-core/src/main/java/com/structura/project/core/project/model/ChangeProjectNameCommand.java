package com.structura.project.core.project.model;

public record ChangeProjectNameCommand(String projectId, String newName) {

    public ChangeProjectNameCommand {
        if (projectId == null || projectId.isBlank()) {
            throw new IllegalArgumentException("projectId must not be null or blank");
        }

        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException("name must not be null or blank");
        }
    }
}
