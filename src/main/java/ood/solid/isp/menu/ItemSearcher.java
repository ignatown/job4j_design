package ood.solid.isp.menu;

import ood.solid.isp.menu.item.Item;

public class ItemSearcher {
   public Item searchByName(String name, Item root) {
       for (Item item: root.getAllItem()) {
           if (item.getName().equals(name)) {
               return item;
           }
       }
       return null;
   }
}
