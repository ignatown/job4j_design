package ood.solid.lsp.productStore.storages;

import ood.solid.lsp.productStore.ExpirationControl;
import ood.solid.lsp.productStore.foods.Food;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage{

    private final List<Food> warehouseStorage = new ArrayList<>();

    @Override
    public void add(Food food) {
        warehouseStorage.add(food);
    }

    @Override
    public List<Food> get() {
        List<Food> list = warehouseStorage;
        return list;
    }

    @Override
    public boolean accept(Food food) {
        return new ExpirationControl().getPercent(food) > 0.75;
    }
}
