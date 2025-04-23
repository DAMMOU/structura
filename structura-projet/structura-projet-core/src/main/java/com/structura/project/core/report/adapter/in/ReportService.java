package com.structura.project.core.report.adapter.in;

import com.structura.project.core.project.model.GetUserSubscriptionPayload;
import com.structura.project.core.project.model.Project;
import com.structura.project.core.project.model.UserSubscription;
import com.structura.project.core.project.model.exception.ProjectNotFoundException;
import com.structura.project.core.project.port.out.http.UserSubscriptionClient;
import com.structura.project.core.project.port.out.persistence.ProjectRepository;
import com.structura.project.core.report.model.GetProjectSummaryCommand;
import com.structura.project.core.report.model.ProjectSummary;
import com.structura.project.core.report.model.ProjectSummaryReport;
import com.structura.project.core.report.model.ReportGenerator;
import com.structura.project.core.report.port.in.ReportUseCases;
import com.structura.project.core.task.model.Task;
import com.structura.project.core.task.model.TaskCriteria;
import com.structura.project.core.task.port.out.persistence.TaskRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ReportService implements ReportUseCases {

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;
    private final UserSubscriptionClient userSubscriptionClient;

    @Override
    public ProjectSummaryReport generateReport(GetProjectSummaryCommand command, ReportGenerator<ProjectSummary, ProjectSummaryReport> reportGenerator) {
        UserSubscription userSubscription = userSubscriptionClient.get(new GetUserSubscriptionPayload(command.triggeredBy()));

        if (!UserSubscription.isExportAllowed(userSubscription)) {
            throw new IllegalStateException("User does not have a premium subscription");
        }

        ProjectSummary projectSummary = getProjectSummary(command);
        return reportGenerator.generate(projectSummary);
    }

    private ProjectSummary getProjectSummary(GetProjectSummaryCommand command) {
        Project project = projectRepository.findById(command.projectId(), false)
                .orElseThrow(() -> new ProjectNotFoundException("Project not found"));

        List<Task> summaryTasks = taskRepository.getTasks(
                new TaskCriteria(command.projectId(), command.status(), command.from(), command.to())

        );
        return new ProjectSummary(
                project.name(),
                project.description(),
                project.owner(),
                summaryTasks
        );
    }
}
