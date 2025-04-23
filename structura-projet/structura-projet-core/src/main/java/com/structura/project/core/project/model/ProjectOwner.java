package com.structura.project.core.project.model;

public record ProjectOwner(String userEmail) {

    public ProjectOwner {
        if (isUserEmailNullOrBlank(userEmail)) {
            throw new IllegalArgumentException("Project owner cannot be null or empty");
        }
    }

    static boolean isUserEmailNullOrBlank(String userEmail) {
        return userEmail == null || userEmail.isBlank();
    }
}
