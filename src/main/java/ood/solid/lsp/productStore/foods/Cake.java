package ood.solid.lsp.productStore.foods;

import java.util.Calendar;

public class Cake extends Food{
    public Cake(String name, Calendar createDate, Calendar expiredDate, int price, int discount) {
        super(name, createDate, expiredDate, price, discount);
    }
}
