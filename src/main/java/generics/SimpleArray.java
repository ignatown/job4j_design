package generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    transient T[] data;
    private int size = 0;

    public SimpleArray(int size) {
        this.size = size;
    }

    public boolean add(T model) {
        data[size] = model;
        size++;
        return true;
    }

    public boolean set(int index, T model) {
        if (index > data.length) {
            throw new NullPointerException("array size does not match");
        }
        data[index] = model;
        return true;
    }

    public boolean remove(int index) {
        if (index > data.length) {
            throw new NullPointerException("array size does not match");
        }
        System.arraycopy(data, index, data, index-1, size-index);
        size--;
        return true;
    }

    public Object get(int index) {
        if (index > data.length) {
            throw new NullPointerException("array size does not match");
        }
        return data[index];
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
               return data[count++];
           }
       }
       return new SimpleArrayIterator();
    }
}
