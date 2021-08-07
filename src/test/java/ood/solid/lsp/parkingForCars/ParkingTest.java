package ood.solid.lsp.parkingForCars;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void whenParkThePassengerCar() {
        assertTrue(new SimpleParking(1,0).parkTheCar(new PassengerCar()));
    }

    @Test
    public void whenParkTheTruck() {
        assertTrue(new SimpleParking(0,3).parkTheCar(new Truck(3)));
    }

    @Test
    public void whenParkTheTruckAtThePassengerCarPlaces() {
        assertTrue(new SimpleParking(3,0).parkTheCar(new Truck(3)));
    }
}