package ood.solid.lsp;

public class Example2 {

    // Пример 2.
    // Ослабленно постусловие.

    public class Transport {
        public boolean willArrive(int fuel, int fuelConsumption, int distance) {
            if (fuel/distance > fuelConsumption) {
                return true;
            } else return false;
        }
    }

    public class Bicycle extends Transport {
        public boolean willArrive() {
            return true;
        }
    }


}
