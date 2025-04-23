package com.structura.project.core.project.model;

public record CreateProjectCommand(String name, String description, String ownerEmail) {
}
