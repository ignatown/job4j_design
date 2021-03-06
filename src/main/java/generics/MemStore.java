package generics;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
            mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = findIndexById(id);
        if (index == -1) {
            return false;
        }
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).equals(findById(id))) {
                mem.set(i, model);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int index = findIndexById(id);
        if (index == -1) {
            return false;
        }
        mem.remove(index);
        return true;
    }

    @Override
    public T findById(String id) {
        int index = findIndexById(id);
        if (index == -1) {
            return null;
        }
        for (T elm:
             mem) {
            if (elm.getId().equals(id)) {
                return elm;
            }
        }
        throw new NullPointerException("id does not exist");
    }

    @Override
    public int findIndexById(String id) {
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}