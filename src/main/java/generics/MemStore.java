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
        Objects.checkIndex(Integer.parseInt(id),mem.size());
        mem.set(Integer.parseInt(id),model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        Objects.checkIndex(Integer.parseInt(id),mem.size());
        mem.remove(Integer.parseInt(id));
        return true;
    }

    @Override
    public T findById(String id) {
        Objects.checkIndex(Integer.parseInt(id),mem.size());
        return mem.get(Integer.parseInt(id));
    }
}