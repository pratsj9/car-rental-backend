package org.acme.reservation.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {

    private Long id;
    public String licensePlateNumber;
    public String manufacturer;
    public String model;

}
