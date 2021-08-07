package ood.solid.lsp.productStore;

import ood.solid.lsp.productStore.foods.Food;

import java.util.GregorianCalendar;

public class ExpirationControl {
    public double getPercent(Food food) {
       return  (food.getExpiredDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis())
                / food.getExpiredDate().getTimeInMillis() - new GregorianCalendar().getTimeInMillis();
    }
}
