package ood.solid.dip;

import java.util.ArrayList;

public class Example2 {
    class Car{
        String registrationNumber;
        String hostsMobileNumber;

        public Car(String registrationNumber, String hostsMobileNumber) {
            this.registrationNumber = registrationNumber;
            this.hostsMobileNumber = hostsMobileNumber;
        }
    }

    class Parking {
        ArrayList<Car> parkedCars = new ArrayList<Car>();
        //Пример 2
        //Используется конкретный класс контейнера обьектов вместо интерфейса.
    }
}
