package ood.solid.lsp.productStore.foods;

import java.util.Calendar;

public class Pizza extends Food{
    public Pizza(String name, Calendar createDate, Calendar expiredDate, int price, int discount) {
        super(name, createDate, expiredDate, price, discount);
    }
}
