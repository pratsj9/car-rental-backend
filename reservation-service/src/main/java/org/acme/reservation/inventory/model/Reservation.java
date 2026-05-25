package org.acme.reservation.inventory.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Reservation {

    private Long id;
    private Long carId;
    private LocalDate startDate;
    private LocalDate endDate;


    /**
     * Check if the given duration overlaps with the reservation.
     * @param startDate 1st day of the reservation
     * @param endDate 2nd day of the reservation
     * @return true if the given duration overlaps with the reservation, false otherwise
     */
    public boolean isReserved(LocalDate startDate, LocalDate endDate) {
        return (!(this.endDate.isBefore(startDate)
                || this.startDate.isAfter(endDate)));
    }
}
