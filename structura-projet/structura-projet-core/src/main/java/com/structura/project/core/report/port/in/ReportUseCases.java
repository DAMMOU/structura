package com.structura.project.core.report.port.in;

import com.structura.project.core.report.model.GetProjectSummaryCommand;
import com.structura.project.core.report.model.ProjectSummary;
import com.structura.project.core.report.model.ProjectSummaryReport;
import com.structura.project.core.report.model.ReportGenerator;

public interface ReportUseCases {

    ProjectSummaryReport generateReport(GetProjectSummaryCommand command,
                                        ReportGenerator<ProjectSummary, ProjectSummaryReport> reportGenerator);
}
