package ood.solid.isp.menu.action;

public class FolderAction implements Action{
    @Override
    public String getActionName() {
        return "SOMETHING FOLDER ACTION";
    }

    @Override
    public void act() {
        System.out.println("DO SOME FOLDER ACTION...");
    }
}
