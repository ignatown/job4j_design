package ood.solid.lsp.parkingForCars;

public class Truck implements Car{

    private final int size;

    public Truck(int size) {
        if (size < 2) throw new IllegalArgumentException("The truck cannot be smaller than 2");
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}
