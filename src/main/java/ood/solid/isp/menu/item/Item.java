package ood.solid.isp.menu.item;

import ood.solid.isp.menu.action.Action;

import java.util.List;

public interface Item {
    void setDeep(int level);
    String getName();
    Action getAction();
    List<Item> getAllItem();
    List<Item> getChilds(int level);
}
