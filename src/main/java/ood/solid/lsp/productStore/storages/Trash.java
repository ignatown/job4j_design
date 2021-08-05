package ood.solid.lsp.productStore.storages;

import ood.solid.lsp.productStore.foods.Food;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage{

    private List<Food> trashStorage = new ArrayList<>();

    @Override
    public void add(Food food) {
        trashStorage.add(food);
    }

    @Override
    public List<Food> get() {
        return trashStorage;
    }
}
