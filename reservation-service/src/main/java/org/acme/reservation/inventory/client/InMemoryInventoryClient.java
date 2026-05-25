package org.acme.reservation.inventory.client;

import jakarta.inject.Singleton;
import org.acme.reservation.inventory.model.Car;

import java.util.List;

@Singleton
public class InMemoryInventoryClient implements InventoryClient {

    private static final List<Car> CARS = List.of(
            new Car(1L, "ABC-123", "Toyota", "Corolla"),
            new Car(2L, "DEF-456", "Honda", "Civic"),
            new Car(3L, "GHI-789", "Ford", "Focus")
    );

    @Override
    public java.util.List<Car> allCars() {
        return CARS;
    }



}
