package collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Iterable<K> {
    private Node<K, V>[] tbl;
    private int content;
    private int size;
    private int mdCnt = 0;
    private float mng = 0.75f;

    public SimpleMap() {
        size = 0;
        content = 8;
        tbl = (Node<K, V>[]) new Node[content];

    }

    public boolean insert(K key, V value) {
        Node<K, V> elm = new Node<>(hash(key), key, value);
        int i = index(key);
        if (tbl[i] != null) {
            return false;
        }
        tbl[i] = elm;
        size++;
        if (size >= content * mng) {
            Node<K, V>[] oldTab = tbl;
            content *= 2;
            tbl = (Node<K, V>[]) new Node[content];
            for (Node<K, V> elmnt : oldTab) {
                if (elm != null) {
                    tbl[elmnt.hash & (content - 1)] = elmnt;
                }
            }
        }
        mdCnt++;
        return true;
    }

    public V get(K key) {
        if (!hasKey(key)) {
            return null;
        }
        return tbl[index(key)].value;
    }

    public boolean delete(K key) {
        if (!hasKey(key)) {
            return false;
        }
        tbl[index(key)] = null;
        mdCnt++;
        size--;
        return true;
    }

    private boolean hasKey(K key) {
        int i = index(key);
        if (!tbl[i].key.equals(key)) {
            return false;
        }
        return true;
    }

    private int index(K key) {
        return hash(key) & (content - 1);
    }

    private int hash(K key) {
        if (key.equals(null)) {
            return 0;
        }
            return key.hashCode();
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private final int expMdCnt = mdCnt;
            int index = 0;

            @Override
            public boolean hasNext() {
                if (expMdCnt != mdCnt) {
                    throw new ConcurrentModificationException();
                }
                if (index == content) {
                    return false;
                }
                if (tbl[index] == null) {
                    index++;
                    return hasNext();
                }
                return true;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return tbl[index++].key;
            }
        };
    }

    public int getCapacity() {
        return content;
    }

    private static class Node<K, V> {
        private final int hash;
        private final K key;
        private V value;
        public Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }
}