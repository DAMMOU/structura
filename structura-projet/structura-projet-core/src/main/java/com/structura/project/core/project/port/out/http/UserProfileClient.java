package com.structura.project.core.project.port.out.http;

import com.structura.project.core.project.model.GetUserProfilesFromEmailsPayload;
import com.structura.project.core.project.model.Member;

import java.util.List;

public interface UserProfileClient {
    List<Member> find(GetUserProfilesFromEmailsPayload payload);
}
