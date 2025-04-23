package com.structura.project.core.project.model;

import java.util.List;

public record Member(String userEmail, String firstName, String lastName) {
    public Member {
        if (userEmail == null) {
            throw new IllegalArgumentException("userEmail must not be null");
        }
    }

    public static List<String> getUserEmails(List<Member> members) {
        return members.stream().map(Member::userEmail).toList();
    }
}
