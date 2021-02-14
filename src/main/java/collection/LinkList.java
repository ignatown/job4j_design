package collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkList<E> implements Iterable<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;
    private int modCount;

    public LinkList() {
        this.first = null;
        this.last = null;
        this.size = 0;
        modCount = 0;
    }

    public void add(E value) {
        Node<E> elm = new Node<>(value, size++);
        if(first == null) {
            first = elm;
        } else {
            last.next = elm;
        }
        last = elm;
        modCount++;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> current = last;

        while (current.index != index) {
            if (current.next == null) {
                return null;
            }
            current = current.next;
        }
        return current.value;
    }

    @Override
    public Iterator<E> iterator() {
        class LinkListIterator<E> implements Iterator<E> {
            private LinkList<E> linkedList;
            private int count = 0;
            private int modCount;

            public LinkListIterator(LinkList<E> linkedList) {
                this.linkedList = linkedList;
                this.modCount = linkedList.getModCount();
            }

            @Override
            public boolean hasNext() {
                if (modCount != linkedList.getModCount()) {
                    throw new ConcurrentModificationException();
                }
                return count < linkedList.getSize();
            }

            @Override
            public E next() {
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                return linkedList.get(count++);
            }
        }
        return new LinkListIterator<E>(this);
    }

    public int getModCount() {
        return modCount;
    }

    public int getSize() {
        return size;
    }

    private class Node<E> {
        private E value;
        private Node<E> next;
        private int index;

        public Node(E value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}