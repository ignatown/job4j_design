package ood.solid.lsp.parkingForCars;

public class SimpleParking implements Parking{
    private final int placesForPassengerCar;
    private final int placesForTruck;
    private int passengerCarsInTheParkingLot;
    private int truckInTheParkingLot;

    public SimpleParking(int placesForPassengerCar, int placesForTruck) {
        if (placesForPassengerCar < 0 || placesForTruck < 0)
            throw new IllegalArgumentException("The number of parking spaces cannot be negative.");
        this.placesForPassengerCar = placesForPassengerCar;
        this.placesForTruck = placesForTruck;
    }

    @Override
    public boolean parkTheCar(Car car) {
        if (car.getSize() == 1) {
            return parkPassengerCar(car);
        } else return parkTruck(car);
    }

    public boolean parkPassengerCar(Car car) {
        if (passengerCarsInTheParkingLot < placesForPassengerCar) {
            passengerCarsInTheParkingLot++;
            return true;
        } return false;
    }

    public boolean parkTruck(Car car) {
        if (truckInTheParkingLot < placesForTruck) {
            truckInTheParkingLot++;
            return true;
        } else {
            int truckSize = car.getSize();
            if (placesForPassengerCar - passengerCarsInTheParkingLot <= truckSize) {
                passengerCarsInTheParkingLot+=truckSize;
                return true;
            }
        }
    return false;
    }
}
