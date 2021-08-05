package ood.solid.lsp.productStore.storages;

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
        return shopStorage;
    }
}
