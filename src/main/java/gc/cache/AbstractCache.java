package gc.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    public V get(K key) {
        SoftReference<V> softReference = cache.get(key);
        if (softReference == null || softReference.get() == null) {
            softReference = new SoftReference<>(load(key));
            cache.put(key, softReference);
        }
        return softReference.get();
    }

    protected abstract V load(K key);

}