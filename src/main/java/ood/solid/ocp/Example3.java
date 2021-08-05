package ood.solid.ocp;

import java.util.ArrayList;
import java.util.List;

public class Example3 {
    private static class ServiceCenter {

        List<Phone> phoneList = new ArrayList<>();

        public void addPhone(Phone phone) {
            phoneList.add(phone);
        }

    }

    private static class Phone {  // private static class Phone implements SuitableForRepair
        private String model;
        //.....
        //.....
    }
    // Пример 3.
    // Столио бы создать интерфейс или абстрактный класс SuitableForRepair
    // и отправить его в дженерик коллекции phoneList.
    // Мало ли сервисный центр захочет расшириться и принимать на ремонт
    // не только телефоны, но и другие устройства.
}
