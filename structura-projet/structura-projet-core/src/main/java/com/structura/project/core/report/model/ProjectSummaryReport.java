package com.structura.project.core.report.model;

import org.springframework.core.io.ByteArrayResource;

public record ProjectSummaryReport(String fileName, ByteArrayResource resource) {

}