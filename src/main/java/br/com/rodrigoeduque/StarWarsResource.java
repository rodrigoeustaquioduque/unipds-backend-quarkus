package br.com.rodrigoeduque;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/starwars")
public class StarWarsResource {

    @RestClient
    private StarWarsService starWarsService;

    @GET
    @Path("/starships")
    public String getStarships() {

        return starWarsService.getStarships();
    }

}
