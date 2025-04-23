package com.structura.project.core.project.model;

import java.util.List;

public record UserSubscription(String userEmail, String name, List<Feature> features) {

    public boolean isExportAllowed() {
        return isExportAllowed(this);
    }

    public static boolean isExportAllowed(UserSubscription userSubscription) {
        return userSubscription != null
                && userSubscription.features != null
                && !userSubscription.features.isEmpty()
                && userSubscription.features.contains(Feature.EXPORT);
    }

    public enum Feature {
        EXPORT
    }
}
