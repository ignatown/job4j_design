package ood.solid.lsp.productStore.storages;

import ood.solid.lsp.productStore.foods.Food;

import java.util.List;

public interface Storage {
    public void add(Food food);
    public List<Food> get();
}
