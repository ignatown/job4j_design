package ood.solid.isp.menu.action;

public class FileAction implements Action{
    @Override
    public String getActionName() {
        return "SOMETHING FILE ACTION";
    }

    @Override
    public void act() {
        System.out.println("DO SOMETHING FILE ACTION...");
    }
}
