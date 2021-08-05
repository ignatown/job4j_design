package ood.solid.lsp.productStore.foods;

import java.util.Calendar;

public class Pies extends Food{
    public Pies(String name, Calendar createDate, Calendar expiredDate, int price, int discount) {
        super(name, createDate, expiredDate, price, discount);
    }
}
