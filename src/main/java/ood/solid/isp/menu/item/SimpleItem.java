package ood.solid.isp.menu.item;

import ood.solid.isp.menu.action.Action;

import java.util.ArrayList;
import java.util.List;

public class SimpleItem implements Item{
    private int deep = 1;
    private final String name;
    private List<Item> chlids = new ArrayList<>();
    private final Action action;

    public SimpleItem(String name, Action action) {
        this.action = action;
        this.name = name;
    }

    public SimpleItem(String name, Action action, List<Item> chlids) {
        this.name = name;
        this.chlids = chlids;
        this.action = action;
    }

    @Override
    public void setDeep(int deep) {
        this.deep = deep;
    }

    @Override
    public void printItem() {
        for (int i = 1;i < deep; i++ ) {
            System.out.print("...");
        }
        System.out.println(name + "   [" + action.getActionName()+"]");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Action getAction() {
        return action;
    }

    @Override
    public List<Item> getAllItem() {
        List<Item> rsl = new ArrayList<>();
        rsl.add(this);
        rsl.addAll(getChilds(deep + 1));
        return rsl;
    }

    @Override
    public List<Item> getChilds(int level) {
        List<Item> rsl = new ArrayList<>();
            for (Item item : chlids) {
                item.setDeep(level);
                List<Item> chlids = item.getAllItem();
                rsl.addAll(chlids);
            }
        return rsl;
    }
}
