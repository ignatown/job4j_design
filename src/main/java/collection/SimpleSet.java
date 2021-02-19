package collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<E> implements Iterable<E> {
    private final SimpleArray<E> mem = new SimpleArray<>();

    public boolean add(E value) {
        for(E elm : mem) {
            if(Objects.equals(elm, value)) {
                return false;
            }
        }
        mem.add(value);
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return mem.iterator();
    }
}