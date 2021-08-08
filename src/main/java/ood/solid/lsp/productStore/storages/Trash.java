package ood.solid.lsp.productStore.storages;

import ood.solid.lsp.productStore.ExpirationControl;
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
        List<Food> list = trashStorage;
        return list;
    }

    @Override
    public boolean accept(Food food) {
        return new ExpirationControl().getPercent(food) < 0;
    }

    @Override
    public void clear() {
        trashStorage.clear();
    }

}
