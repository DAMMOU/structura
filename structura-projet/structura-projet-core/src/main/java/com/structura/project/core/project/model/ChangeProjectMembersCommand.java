package com.structura.project.core.project.model;

import java.util.List;

public record ChangeProjectMembersCommand(String projectId, List<ProjectMember> members) {

    public ChangeProjectMembersCommand {
        if (projectId == null) {
            throw new IllegalArgumentException("projectId must not be null");
        }
    }

    public boolean hasMembers() {
        return members != null && !members.isEmpty();
    }

    public List<String> getMembersEmails() {
        return members != null
                ? members.stream().map(ProjectMember::getUserEmail).toList()
                : null;
    }
}
