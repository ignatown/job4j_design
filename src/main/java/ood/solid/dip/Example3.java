package ood.solid.dip;

public class Example3 {

    // Пример 3
    // Метод принимает в качестве параметра реализацию, а не абстракцию

    interface Barista {
        void makeSomeCoffee(Espresso espresso);
    }

    interface Coffee{
        void smellDelicious();
    }

    class Espresso implements Coffee{

        @Override
        public void smellDelicious() {
            System.out.println("Smells like espresso...");
        }
    }
}
