import java.util.Arrays;

public class MyHashMap<K, V> {
    static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;
        Entry (K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
    private static final int DEFAULT_CAPACITY = 15;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private Entry<K, V>[] buckets;
    private float loadFactor;
    private int size;

    public MyHashMap(int cap, float loadFactor) {
        if (cap <= 0) {
            throw new IllegalArgumentException("The capacity of MyHashMap should larger than 0");
        }
        buckets = (Entry<K,V>[]) (new Entry[cap]);
        size = 0;
        this.loadFactor = loadFactor;
    }

    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int cap) {
        this(cap, DEFAULT_LOAD_FACTOR);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Arrays.fill(buckets, null);
        size = 0;
    }

    public V get(K key) {
        int index = getIndex(key);
        Entry<K, V> head = buckets[index];
        Entry<K, V> cur = head;
        while (cur != null) {
            if (isEqualKey(cur.getKey(), key)) {
                return cur.getValue();
            }
            cur = cur.next;
        }
        return null;
    }

    public V put(K key, V value) {
        int index = getIndex(key);
        Entry<K, V> head = buckets[index];
        Entry<K, V> cur = head;
        while (cur != null) {
            if (isEqualKey(cur.getKey(), key)) {
                V res = cur.getValue();
                cur.setValue(value);
                return res;
            }
            cur = cur.next;
        }
        Entry<K, V> newHead = new Entry<K, V>(key, value);
        newHead.next = head;
        buckets[index] = newHead;
        size++;
        if (needRehash()) {
            rehash();
        }
        return null;
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        Entry<K, V> head = buckets[index];
        Entry<K, V> cur = head;
        while (cur != null) {
            if (isEqualKey(cur.getKey(), key)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public boolean containsValue(V value) {
        if (isEmpty()) {
            return false;
        }
        for (Entry<K, V> entry : buckets) {
            if (isEqualValue(entry.getValue(), value)) {
                return true;
            }
            entry = entry.next;
        }
        return false;
    }

    public V remove(K key) {
        int index = getIndex(key);
        Entry<K, V> head = buckets[index];
        Entry<K, V> prev = null;
        Entry<K, V> cur = head;
        while (cur != null) {
            if (isEqualKey(cur.getKey(), key)) {
                V res = cur.getValue();
                if (prev == null) {
                    buckets[index] = cur.next;
                } else {
                    prev.next = cur.next;
                }
                size--;
                return res;
            }
            prev = cur;
            cur = cur.next;
        }
        return null;
    }

    private boolean needRehash() {
        float ratio = (size + 0.0f) / buckets.length;
        return ratio >= loadFactor;
    }

    private void rehash() {
        Entry<K, V>[] newBuckets = (Entry<K,V>[]) new Entry[buckets.length * 2];
        for (int i = 0; i < buckets.length; i++) {
            int index = hash(buckets[i].getKey()) % newBuckets.length;
            newBuckets[index] = buckets[i];
        }
        buckets = newBuckets;
    }

    private int getIndex(K key) {
        return hash(key) % buckets.length;
    }

    private int hash(K key) {
        if (key == null) {
            return 0;
        } else {
            return key.hashCode() & 0X7FFFFFFF;
        }
    }

    private boolean isEqualKey(K k1, K k2) {
        return k1 == k2 || (k1 != null && k1.equals(k2));
    }

    private boolean isEqualValue(V v1, V v2) {
        return v1 == v2 || (v1 != null && v1.equals(v2));
    }
}
