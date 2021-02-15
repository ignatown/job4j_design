package generics;

import java.util.Objects;

public class RoleStore implements Store<Role> {

    private final Store<Role> store = new MemStore<>();

    @Override
    public void add(Role model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        store.replace(id,model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        store.delete(id);
        return true;
    }

    @Override
    public Role findById(String id) {
        return store.findById(id);
    }

    @Override
    public int findIndexById(String id) {
        return store.findIndexById(id);
    }
}