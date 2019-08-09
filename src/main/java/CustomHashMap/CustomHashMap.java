package CustomHashMap;

import java.util.*;

import static java.util.stream.Collectors.toSet;

public class CustomHashMap<K, V> implements Map<K, V> {
    private HashSet<EntryImpl<K, V>> storage;
    public CustomHashMap() {
        storage = new HashSet<>();
    }
    @Override
    public int size() {
        return 0;
    }
    @Override
    public boolean isEmpty() {
        return false;
    }
    @Override
    public boolean containsKey(Object key) {
        return false;
    }
    @Override
    public boolean containsValue(Object value) {
        return false;
    }
    @Override
    public V get(Object key) {



        return null;
    }
    @Override
    public V put(K key, V value) {
        EntryImpl<K, V> entry = new EntryImpl<>(key, value);
        if (storage.contains(entry)) {
            storage.remove(entry);
        }
        storage.add(entry);
        return value;
    }
    @Override
    public V remove(Object key) {

        return null;
    }
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
    }
    @Override
    public void clear() {
    }
    @Override
    public Set<K> keySet() {
        return storage.stream()
                .map(entry -> entry.getKey())
                .collect(toSet());
    }
    @Override
    public Collection<V> values() {
        return storage.stream()
                .map(EntryImpl :: getValue)
                .collect(toSet());
    }
    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
    @Override
    public String toString() {
        return this.storage.toString();
    }
    public static class EntryImpl<K, V> implements Entry<K, V> {
        private K key;
        private V value;
        public EntryImpl(K key, V value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public K getKey() {
            return this.key;
        }
        @Override
        public V getValue() {
            return this.value;
        }
        @Override
        public V setValue(V value) {
            return this.value = value;
        }
        @Override
        public int hashCode() {
            return key.hashCode();
        }
        @Override
        public String toString() {
            return key + "=" + value;
        }
        @Override
        public boolean equals(Object obj) {
            return Objects.equals(obj, key);
        }
    }
}
