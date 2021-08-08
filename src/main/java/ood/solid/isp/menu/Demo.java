package ood.solid.isp.menu;

import ood.solid.isp.menu.action.Action;
import ood.solid.isp.menu.action.FileAction;
import ood.solid.isp.menu.action.FolderAction;
import ood.solid.isp.menu.item.Item;
import ood.solid.isp.menu.item.SimpleItem;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        ItemSearcher itemSearcher = new ItemSearcher();
        Action folderAction = new FolderAction();
        Action fileAction = new FileAction();
        SimpleItem folder1 = new SimpleItem("My pets", folderAction,
                List.of(new SimpleItem("Cat video", fileAction),
                        new SimpleItem("Dog photo", fileAction)));
        SimpleItem folder2 = new SimpleItem("Job", folderAction,
                List.of(new SimpleItem("Work", fileAction),
                        new SimpleItem("Tasks", fileAction),
                        new SimpleItem("Report", fileAction)));
        SimpleItem root = new SimpleItem("ROOT", folderAction, List.of(folder1, folder2));
        for (Item item : root.getAllItem()) {
            item.printItem();
        }

        itemSearcher.searchByName("Work", root).getAction().act();
    }
}
