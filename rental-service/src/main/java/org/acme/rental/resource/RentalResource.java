package org.acme.rental.resource;

import io.quarkus.logging.Log;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.rental.model.Rental;

import java.util.concurrent.atomic.AtomicLong;

@Path("rentals")
public class RentalResource {

    private final AtomicLong ids = new AtomicLong(0);

    @Path("/start/{userId}/{reservationId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Rental start(@PathParam("userId") String userId, @PathParam("reservationId") Long reservationId) {
        Log.infof("Starting rental for user: %s , with reservation: %s", userId, reservationId);
        return new Rental(ids.incrementAndGet(), userId, reservationId, null);
    }
}
