package collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    transient T[] container;
    private int size = 0;
    private int capacity = 10;

    public T get(int index) {
        Objects.checkIndex(index,size);
        return container[index];
    }

    public void add(T model) {
        if (size == capacity) {
            capacity+=10;
        }
        container[size] = model;
        size++;
    }

    @Override
    public Iterator<T> iterator() {
        class SimpleArrayIterator implements Iterator<T>{
            int count = 0;
            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[count++];
            }
        }
        return new SimpleArrayIterator();
    }
}