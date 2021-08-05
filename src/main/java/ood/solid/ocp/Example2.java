package ood.solid.ocp;

public class Example2 {

    private static class Car{
        int horsepower;
        public void move() {}
    }

    private static class Bicycle extends Car {}
    // Пример 2.
    // Хоть и велосипед и автомобиль могут двигаться,
    // но у велосипеда нет такой характеристики - колличество лошадиных сил.
    // Стоило бы создать отдельный интерфейс - CanMove
}
