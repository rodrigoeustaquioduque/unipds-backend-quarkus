package br.com.rodrigoeduque;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Readiness
public class ReadinessCheck implements HealthCheck {

    @RestClient
    private StarWarsService starWarsService;

    @Override
    public HealthCheckResponse call() {
        if (starWarsService.getStarships().contains(StarWarsService.MSG_ERROR)) {
            return HealthCheckResponse.down("Readiness Check   -   ERROR   -   ERROR   ");
        }
        return HealthCheckResponse.up("Readiness Check   -   UP   -   OK   ");
    }
}
