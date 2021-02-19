package collection;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();
    private int size = 0;

    public T pop() {
        size--;
        return linked.deleteFirst();
    }

    public void push(T value) {
        linked.add(value);
        size++;
    }

    public boolean isEmpty(){
        if (size == 0) {
            return true;
        }
        return false;
    }
}