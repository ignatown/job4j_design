package collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private int size = 0;
    private int capacity = 10;
    private int modCount;
    private Object[] container = new Object[capacity];

    public int getSize() {
        return size;
    }

    public int getModCount() {
        return modCount;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) container[index];
    }

    public void add(T model) {
        if (size == container.length) {
            resize(container.length * 2);
        }
        container[size++] = model;
        modCount++;
    }

    private void resize(int newLength) {
        Object[] newContainer = new Object[newLength];
        System.arraycopy(container, 0, newContainer, 0, size);
        container = newContainer;
    }

    @Override
    public Iterator<T> iterator() {
        class SimpleArrayIterator<T> implements Iterator<T> {
            private final SimpleArray<T> mem;
            private int count = 0;
            private final int expectedModCount;

            public SimpleArrayIterator(SimpleArray<T> array) {
                this.mem = array;
                this.expectedModCount = array.getModCount();
            }

            @Override
            public boolean hasNext() {
                if(isModified()) {
                    throw new ConcurrentModificationException();
                }
                return count < mem.getSize();
            }

            @Override
            public T next() {
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                return mem.get(count++);
            }

            private boolean isModified() {
                return mem.getModCount() != expectedModCount;
            }
        }
        return new SimpleArrayIterator<>(this);
    }
}