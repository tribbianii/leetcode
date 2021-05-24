package leetcode;

import java.util.Arrays;

public class MyHashMap<K extends Comparable<K>, V extends Comparable<V>> {
    public static class Pair<K, V> {
        final K key;
        V value;
        Pair<K, V> next;
        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
        public void setValue (V value) {
            this.value = value;
        }
    }
    public static final int DEFAULT_CAPACITY = 16;
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private Pair<K, V>[] array;
    private int size;
    private float loadFactor;
    
    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }
    public MyHashMap(int cap, float loadFactor) {
        if (cap <= 0) {
            throw new IllegalArgumentException("cap canot be <= 0");
        }
        this.array = (Pair<K, V>[])(new Pair[cap]);
        this.size = 0;
        this.loadFactor = loadFactor;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void clear() {
        Arrays.fill(this.array, null);
        size = 0;
    }
    private int hash(K key) {
        if (key == null) {
            return 0;
        }
        //return pair.key.hashCode() & Integer_MAX_VALUE;
        return key.hashCode() & 0X7FFFFFFF;   
    }
    private int getIndex(K key) {
        return hash(key) % array.length;
    }
    private boolean equalsValue(V v1, V v2) {
        if (v1 == null && v2 == null) {
            return true;
        }
        if (v1 == null || v2 == null) {
            return false;
        }
        return v1.equals(v2);
        //retrun v1 == v2 || v1 != null && v1.equals(v2);
    }
    private boolean equalsKey(K k1, K k2) {
        return k1 == k2 || k1 != null && k1.equals(k2);
    }
    public boolean containsKey(K key) {
        int index = getIndex(key);
        Pair<K, V> pair = array[index];
        while (pair != null) {
            if (equalsKey(pair.key, key)) {
                return true;
            }
            pair = pair.next;
        }
        return false;
    }
    public V get(K key) {
        int index = getIndex(key);
        Pair<K, V> pair = array[index];
        while (pair != null) {
            if (equalsKey(key, pair.key)) {
                return pair.value;
            }
            pair = pair.next;
        }
        return null;
    }
    //if pair with key exists, return ald value
    //else return null
    public V put(K key, V value) {
        int index = getIndex(key);
        Pair<K, V> pair = array[index];
        Pair<K, V> head = pair;
        while (pair != null) {
            if (equalsKey(key, pair.key)) {
                V result = pair.value;
                pair.value = value;
                return result;
            }
            pair = pair.next;
        }
        Pair<K, V> newPair = new Pair<>(key, value);
        newPair.next = head;
        array[index] = newPair;
        size ++;
        if (needRehashing()) {
            rehashing();
        }
        return null;
    }
    private boolean needRehashing() {
        float ratio = (size + 0.0f) / array.length;
        return ratio >= loadFactor;
    }
    private boolean rehashing() {
        Pair<K, V>[] oldArray = array;
        array = (Pair<K, V>[])(new Pair[oldArray.length]);
        for (Pair<K, V> pair : oldArray) {
            while (pair != null) {
                put(pair.key, pair.value);
                pair = pair.next;
            }
        }
        return true;
    }
    //if pair with key exist, remove it and return value
    //else return null
    public V remove(K key) {
        Pair<K, V> head = new Pair<>(null, null);
        head.next = array[getIndex(key)];
        while (head.next != null) {
            if (equalsKey(head.next.key, key)) {
                V value = head.next.value;
                head.next = head.next.next;
                size --;
                return value;
            }
            head = head.next;
        }
        return null;
    }
}