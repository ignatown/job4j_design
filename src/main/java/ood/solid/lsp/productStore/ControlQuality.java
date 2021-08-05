package ood.solid.lsp.productStore;

import ood.solid.lsp.productStore.foods.Food;
import ood.solid.lsp.productStore.storages.Shop;
import ood.solid.lsp.productStore.storages.Storage;
import ood.solid.lsp.productStore.storages.Trash;
import ood.solid.lsp.productStore.storages.Warehouse;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class ControlQuality {
    public static Map<String, Storage> storageMap;
    static {
        storageMap = new HashMap<>();
        storageMap.put("Shop", new Shop());
        storageMap.put("Warehouse", new Warehouse());
        storageMap.put("Trash", new Trash());
    }

    public ControlQuality( Map<String, Storage> storageMap) {
        this.storageMap = storageMap;
    }

    public Map<String, Storage> getStorages() {
        return storageMap;
    }

    private Storage storageSelection(Food food) {
        Storage rsl;
        double shelfLife = (food.getExpiredDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis())
                / food.getExpiredDate().getTimeInMillis() - new GregorianCalendar().getTimeInMillis();
        if (shelfLife > 0 && shelfLife < 0.75) {
            if (shelfLife < 0.25) {
                food.setDiscount(food.getDiscount() + 0.5);
            }
            rsl = getStorages().get("Shop");
        } else if (shelfLife > 0.75) {
            rsl = getStorages().get("Warehouse");
        } else {
            rsl = getStorages().get("Trash");
        }
        return rsl;
    }

    private void process(Food food) {
        storageSelection(food).add(food);
    }
}
