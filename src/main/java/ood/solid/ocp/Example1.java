package ood.solid.ocp;

public class Example1 {

    private static class Human {
        public String run() {
            return "Human is running..";
        }
    }

    private static class Dog extends Human {
        @Override
        public String run() {
            return "Dog is running..";
        }
    }
    // Пример 1.
    // Собака не человек, хоть и тоже может бегатью.
    // Следовало бы создать интерфейс CanRun и имплементить от него Human и Dog.
}
