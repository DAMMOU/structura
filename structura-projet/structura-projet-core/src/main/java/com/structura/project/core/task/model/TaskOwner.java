package com.structura.project.core.task.model;

public record TaskOwner(String userEmail) {

    public TaskOwner {
        if (isUserEmailNullOrBlank(userEmail)) {
            throw new IllegalArgumentException("userEmail must not be null or blank");
        }
    }

    static boolean isUserEmailNullOrBlank(String userEmail) {
        return userEmail == null || userEmail.isBlank();
    }
}
