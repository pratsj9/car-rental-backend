package org.acme.reservation.inventory.client;

import org.acme.reservation.inventory.model.Car;

import java.util.List;

public interface InventoryClient {

    List<Car> allCars();
}
