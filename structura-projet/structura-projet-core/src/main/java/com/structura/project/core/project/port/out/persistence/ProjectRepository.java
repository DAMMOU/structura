package com.structura.project.core.project.port.out.persistence;

import com.structura.project.core.project.model.Project;
import com.structura.project.core.project.model.ProjectCriteria;
import com.structura.project.core.project.model.ProjectMember;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    Project save(Project project);

    Project changeProjectName(String projectId, String newName);

    Project changeProjectDescription(String projectId, String newDescription);

    Project changeProjectMembers(String projectId, List<ProjectMember> projectMembers);

    void archiveProject(String projectId);

    Optional<Project> findById(String id, boolean archived);

    List<Project> findAll(ProjectCriteria criteria);
}
