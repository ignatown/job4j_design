package ood.solid.lsp.productStore;

import ood.solid.lsp.productStore.foods.Food;
import ood.solid.lsp.productStore.storages.Shop;
import ood.solid.lsp.productStore.storages.Storage;
import ood.solid.lsp.productStore.storages.Trash;
import ood.solid.lsp.productStore.storages.Warehouse;

import java.util.*;

public class ControlQuality {
    private static List<Storage> storageList;
    static {
        storageList = new ArrayList<>();
        storageList.add(new Shop());
        storageList.add(new Warehouse());
        storageList.add(new Trash());
    }

    public ControlQuality( List<Storage> storageList) {
        ControlQuality.storageList = storageList;
    }

    public List<Storage> getStorages() {
        List<Storage> storages = storageList;
        return storages;
    }

    private void process(Food food) {
        for (Storage storage: storageList) {
            if (storage.accept(food)) {
                storage.add(food);
            }
        }
    }

    public void resort(){
        List<Food> resortFoodList = new ArrayList<>();
        for (Storage storage : storageList) {
            resortFoodList.addAll(storage.get());
            storage.clear();
        }
        for (Food food : resortFoodList) {
          process(food);
        }
    }
}
