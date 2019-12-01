package com.rs.probes;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ProbesHealthIndicator implements HealthIndicator {

    private static final String message_key = "Recipes System";

    @Override
    public Health health() {

        if (!isServiceUp()) {
            return Health.down().withDetail(message_key, "Not Available").build();
        }
        return Health.up().withDetail(message_key, "Available").build();
    }

    private boolean isServiceUp () {
        return true;
    }
}
