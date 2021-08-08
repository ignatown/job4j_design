package ood.solid.lsp.productStore.storages;

import ood.solid.lsp.productStore.ExpirationControl;
import ood.solid.lsp.productStore.foods.Food;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage{

    private List<Food> shopStorage = new ArrayList<>();

    @Override
    public void add(Food food) {
        shopStorage.add(food);
    }

    @Override
    public List<Food> get() {
        List<Food> list = shopStorage;
        return list;
    }

    @Override
    public boolean accept(Food food) {
    double shelfLife = new ExpirationControl().getPercent(food);
        if (shelfLife > 0 && shelfLife < 0.75) {
            if (shelfLife < 0.25) {
                food.setDiscount(food.getDiscount() + 0.5);
            }
           return true;
    } return false;
    }

    @Override
    public void clear() {
        shopStorage.clear();
    }
}
