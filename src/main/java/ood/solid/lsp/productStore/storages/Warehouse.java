package ood.solid.lsp.productStore.storages;

import ood.solid.lsp.productStore.foods.Food;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage{

    private List<Food> warehouseStorage = new ArrayList<>();

    @Override
    public void add(Food food) {
        warehouseStorage.add(food);
    }

    @Override
    public List<Food> get() {
        return warehouseStorage;
    }
}
