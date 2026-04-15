package DSA;

public class MyHashMap<K, V> {
    private Entry<K, V>[] buckets;
    private final int CAPACITY = 16;


    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        buckets = new Entry[CAPACITY];
    }

    public void put(K key, V value) {
        int index = Math.abs(key.hashCode()) % CAPACITY;
        Entry<K, V> current =  buckets[index];
        while(current!=null){
            if(current.key.equals(key)){
                current.value = value;
                return;
            }
            current = current.next;
        }
        Entry<K,V> newEntry =  new Entry<>(key, value);
        newEntry.next = buckets[index];
        buckets[index] = newEntry;

    }

    public V get(K key) {
        int index = Math.abs(key.hashCode()) % CAPACITY;
        if (buckets[index] != null) {
            Entry<K, V> oldEntry = buckets[index];
            while (oldEntry != null) {
                if (oldEntry.key.equals(key)) {
                    return oldEntry.value;
                }
                oldEntry = oldEntry.next;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = Math.abs(key.hashCode()) % CAPACITY;
        if (buckets[index] != null) {
            Entry<K, V> oldEntry = buckets[index];
            //head case
            if (oldEntry.key.equals(key)) {
                oldEntry = oldEntry.next;
                buckets[index] = oldEntry;
                return;
            }
            while (oldEntry.next != null) {
                if (oldEntry.next.key.equals(key)) {
                    oldEntry.next = oldEntry.next.next;
                    return;
                }
                oldEntry = oldEntry.next;
            }
        }
    }

    public boolean containsKey(K key) {
        int index = Math.abs(key.hashCode()) % CAPACITY;
        if (buckets[index] != null) {
            Entry<K, V> oldEntry = buckets[index];
            while (oldEntry != null) {
                if (oldEntry.key.equals(key)) {
                    return true;
                }
                oldEntry = oldEntry.next;
            }
        }
        return false;
    }
}
