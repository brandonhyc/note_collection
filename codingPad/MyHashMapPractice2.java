package codingPad;


class GenericHashMap<K, V> {

    final int DEFAULT_CAPACITY = 30;
    int capacity = DEFAULT_CAPACITY;
    Entry<K, V>[] array;
    int size = 0;

    public GenericHashMap() {
        array = new Entry[capacity];
    }

    private void rehash() {
        capacity = 2;
        Entry<K, V>[] newArray = new Entry[capacity];

        for (int i = 0; i < array.length; i++) {
            Entry<K, V> head = array[i];
            while (head != null) {
                put(head.key, head.value, newArray);
                head = head.next;
            }
        }

        array = newArray;
    }



    private void put(K key, V value, Entry<K, V>[] buckets) {
        int index =  key.hashCode() % buckets.length;
        if (buckets[index] == null) {
            buckets[index] = new Entry<>(key, value);
            size++;
        }
        else {
            Entry<K, V> curr = buckets[index], prev = null;
            while (curr != null) {
                if (curr.key.equals(key)) {
                    curr.value = value;
                    break;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }
            if (curr == null) {
                prev.next = new Entry(key, value);
                size++;
            }

            if (size == capacity / 3) {
                rehash();
            }
        }
    }


    public void put(K key, V value) {
        put(key, value, array);
    }


    public V get(K key) {
        int index =  key.hashCode() % array.length;
        if (array[index] == null) return null;

        Entry<K, V> curr = array[index];
        while (curr != null) {
            if (curr.key.equals(key)) {
                return curr.value;
            } else {
                curr = curr.next;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index =  key.hashCode() % array.length;
        if (array[index] == null) return;

        Entry<K, V> dummy = new Entry<K, V>(null, null);
        Entry<K, V> curr = array[index], prev = dummy;
        if (curr.key.equals(key)) {
            array[index] = curr.next;
        } else {
            prev.next = curr;
            while (curr != null) {
                if (curr.key.equals(key)) {
                    prev.next = curr.next;
                    size--;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }
        }


    }

    public class Entry<K, V> {
        K key;
        V value;
        Entry next;

        private Entry(K k, V v) {
            this.key = k;
            this.value = v;
        }
    }
}