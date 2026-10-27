package br.com.rodrigoeduque;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/unipds")
public class UniPDSResource {

    private int i = 0;

    @GET
    public int getI() {
        return i;
    }

    @POST
    public void postI() {
        i++;
    }

    @DELETE
    public void deleteI() {
        i--;
    }

    @PUT
    public void putI(int i) {
        this.i = i;
    }


}
