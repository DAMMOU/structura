package com.structura.project.core.project.port.out.http;

import com.structura.project.core.project.model.GetUserSubscriptionPayload;
import com.structura.project.core.project.model.UserSubscription;

public interface UserSubscriptionClient {
    UserSubscription get(GetUserSubscriptionPayload payload);
}
