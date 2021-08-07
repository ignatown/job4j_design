package ood.solid.lsp.parkingForCars;

public class PassengerCar implements Car{

    private final int size = 1;

    @Override
    public int getSize() {
        return size;
    }
}
