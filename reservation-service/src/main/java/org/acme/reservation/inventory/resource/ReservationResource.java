package org.acme.reservation.inventory.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.reservation.inventory.Dao.ReservationsRepository;
import org.acme.reservation.inventory.client.InventoryClient;
import org.acme.reservation.inventory.model.Car;
import org.acme.reservation.inventory.model.Reservation;
import org.jboss.resteasy.reactive.RestQuery;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("reservations")
@Produces(MediaType.APPLICATION_JSON)
public class ReservationResource {

    private final ReservationsRepository reservationsRepository;
    private final InventoryClient inventoryClient;

    public ReservationResource(ReservationsRepository reservationsRepository, InventoryClient inventoryClient) {
        this.reservationsRepository = reservationsRepository;
        this.inventoryClient = inventoryClient;
    }


    @GET
    @Path("availability")
    public Collection<Car> getAvailableCars(@RestQuery LocalDate startDate, @RestQuery LocalDate endDate) {
        List<Car> allCars = inventoryClient.allCars();
        Map<Long, Car> carsById = new HashMap<>();
        allCars.forEach(car -> carsById.put(car.getId(), car));

        //Get all current reservations
        List<Reservation> reservations = reservationsRepository.findAll();
        reservations.forEach(reservation -> {
            if (reservation.isReserved(startDate, endDate)) {
                carsById.remove(reservation.getCarId());
            }
        });

        return carsById.values();
    }


    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Reservation createReservation(Reservation reservation) {
        return reservationsRepository.save(reservation);
    }



}
