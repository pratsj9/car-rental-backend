package org.acme.reservation.inventory.Dao;

import org.acme.reservation.inventory.model.Reservation;

import java.util.List;

public interface ReservationsRepository {

    List<Reservation> findAll();


    Reservation save(Reservation reservation);
}
