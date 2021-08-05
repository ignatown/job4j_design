package ood.solid.lsp.productStore.foods;

import java.util.Calendar;

public class Juice extends Food{
    public Juice(String name, Calendar createDate, Calendar expiredDate, int price, int discount) {
        super(name, createDate, expiredDate, price, discount);
    }
}
