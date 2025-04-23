package com.structura.project.core.project.model;

import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public final class ProjectMember {
    private final String userEmail;

    public ProjectMember(String userEmail) {
        this.userEmail = Objects.requireNonNull(userEmail, "userEmail must not be null");
    }

    public static List<String> getUserEmails(List<ProjectMember> projectMembers) {
        return projectMembers != null
                ? projectMembers.stream().map(ProjectMember::getUserEmail).toList()
                : null;
    }
}
