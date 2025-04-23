package com.structura.project.core.report.model;

import com.structura.project.core.project.model.ProjectOwner;
import com.structura.project.core.task.model.Task;

import java.util.List;

public record ProjectSummary(
        String projectName,
        String projectDescription,
        ProjectOwner owner,
        List<Task> tasks
) {

}
