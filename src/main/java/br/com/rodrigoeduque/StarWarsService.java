package br.com.rodrigoeduque;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.time.temporal.ChronoUnit;

@RegisterRestClient(baseUri = "https://s1wapi.info/api/")
public interface StarWarsService {


    public static final String MSG_ERROR = "Error - Fallback  |  ";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/starships")
    @Timeout(
            value = 3,
            unit = ChronoUnit.SECONDS
    )
    @Fallback(fallbackMethod = "getStarshipsFallback")
    @CircuitBreaker(
            delay = 5000L,
            requestVolumeThreshold = 2,
            failureRatio = 0.5,
            successThreshold = 2
    )
    public String getStarships();

    default String getStarshipsFallback(){
        return MSG_ERROR;
    };



}
