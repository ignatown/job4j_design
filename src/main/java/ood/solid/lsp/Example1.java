package ood.solid.lsp;

public class Example1 {

    // Пример 1.
    // Усилено предусловие.

    public class Stroll{
        public void move(int speed) {
            if (speed>0) {
                System.out.println("Walking..");
            } else throw new IllegalArgumentException();
        }
    }

    public class Jogging extends Stroll {
        public void move(int speed) {
            if (speed > 5) {
                System.out.println("Running");
            } else throw new IllegalArgumentException();
        }
    }
}
