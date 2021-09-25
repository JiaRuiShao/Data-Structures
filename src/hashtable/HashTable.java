package hashtable;

import java.util.ArrayList;

/**
 * HashTable Implementation using ArrayList.
 * Avoid collision using Chaining method.
 */
class HashTable {

    private ArrayList<HashEntry> bucket; // to store chains of slots
    private int slots; // num of slots in each bucket
    private int size; // total hashed keys

    public HashTable() {
        bucket = new ArrayList<HashEntry>();
        slots = 5;
        size = 0;

        //Initialize nodes
        for (int i = 0; i < slots; i++) {
            bucket.add(null);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Look for the index based on key search function.
     *
     * @param key the input key
     * @return the hashed index given key
     */
    private int getIndex(String key) {
        int hashCode = key.hashCode();
        return hashCode % slots; // index
    }

    /**
     * Insert the key-value pair into table.
     *
     * @param key   the given key
     * @param value the given value
     */
    public void insert(String key, int value) {
        int index = getIndex(key);
        HashEntry curr = bucket.get(index);
        // See if the key exists
        while (curr != null) {
            // override the previous value
            if (curr.key.equals(key)) {
                curr.value = value;
                return;
            }
            curr = curr.next;
        }

        // Insert key into the bucket
        size++;
        /*// insert at head
        head = bucket.get(index);
        HashEntry new_slot = new HashEntry(key, value);
        new_slot.next = head;
        bucket.set(index, new_slot); // new_slot as new head*/
        // insert at tail
        curr = new HashEntry(key, value);

        // If 75% of the array gets filled, double the size
        if ((1.0 * size) / slots >= 0.75) {
            ArrayList<HashEntry> temp = bucket;
            bucket = new ArrayList<>();
            slots = 2 * slots;
            size = 0;

            System.arraycopy(temp, 0, bucket, 0, temp.size());

            /*for (int i = 0; i < slots; i++) {
                bucket.add(null);
            }

            for (HashEntry curr : temp) {
                while (curr != null) {
                    insert(curr.key, curr.value);
                    curr = curr.next;
                }
            }*/
        }
    }

    /**
     * Fetch a value for key from table.
     *
     * @param key the key to be search for
     * @return the value that stored with the key
     */
    public int get(String key) {
        int index = getIndex(key);
        HashEntry curr = bucket.get(index);

        // Find the key in slots
        while (curr != null) {
            if (curr.key.equals(key)) {
                return curr.value;
            }
            curr = curr.next;
        }

        // If key does not exist
        return 0;
    }

    /**
     * Delete the key-value pair given a key
     *
     * @param key the given key
     * @return the value stored in that key if the key exist; return null if it doesn't
     */
    public Integer delete(String key) {

        int index = getIndex(key);
        HashEntry curr = bucket.get(index);

        // Search the key in slots
        HashEntry prev = null;
        while (curr != null) {
            // If the key exists
            if (curr.key.equals(key)) {
                break;
            }
            //If the key not found yet
            prev = curr;
            curr = curr.next;
        }

        // If the key does not exist
        if (curr == null) {
            return null;
        }

        // Delete the value by key
        size--;
        if (prev != null) {
            prev.next = curr.next;
        } else {// the node we want to delete is the head of that LL
            bucket.set(index, curr.next);
        }
        return curr.value;
    }
}