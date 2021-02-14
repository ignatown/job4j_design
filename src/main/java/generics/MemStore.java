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
        mem.remove(findById(id));
        return true;
    }

    @Override
    public T findById(String id) {
        for (T elm:
             mem) {
            if (elm.getId().equals(id)) {
                return elm;
            }
        }
        throw new NullPointerException("id does not exist");
    }
}