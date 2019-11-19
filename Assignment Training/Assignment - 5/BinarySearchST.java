/**
 * @author SaiKotesh0102
 */

import java.util.*;
import java.lang.*;
/**
 * Binary Search Symbol Table API
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchST<Key extends Comparable<Key>, Value>{
    private Key[] keys;
    private Value[] values;
    private int size;

    public BinarySearchST(){
        this.keys = (Key[]) new Comparable[2];
        this.values = (Value[]) new Object[2];
        this.size = 0;
    }
    /**
     * resize method to change the size of the array when it is full or 
     * half by increasing the size by a element
     */
    private void resize() {
        keys = Arrays.copyOf(keys, size + 1);
        values = Arrays.copyOf(values, size + 1);
    }
    /**
     * put method inserts an element into symbol table
     * Time Complexity = O(N)
     * @param key
     * @param value
     */
    public void put(final Key key, final Value value) {
        if (value == null) {
            delete(key);
            return;
        }

        // if(keys[size].compareTo(key) < 0){
        //     size++;
        //     keys[size] = key;
        //     values[size] = value;
        //     // size++;
        //     return;
        // }

        int rank = rank(key);

        if (rank < size && keys[rank].compareTo(key) == 0) {
            values[rank] = value;
            return;
        }

        if (size == keys.length) {
            resize();
        }

        for (int j = size; j > rank; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }

        keys[rank] = key;
        values[rank] = value;
        size++;
    }
    /**
     * get method gives us the value of a particular key
     * @param key
     * @return value of a particular key
     */
    public Value get(final Key key) {
        int rank = rank(key);
        if (rank < size && (keys[rank].compareTo(key) == 0)) {
            return values[rank];
        }
        return null;
    }
    /**
     * Time Complexity : O(N)
     * @param key
     * @return no of values less than that key
     */
    public int rank(final Key key){
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comp = key.compareTo(keys[mid]);
            if (comp < 0) {
                high = mid - 1;
            } else if (comp > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    public Key max() {
        return keys[size - 1];
    }

    public Key min() {
        return keys[0];
    }
    /**
     * Floor method returns the Key that is largest key less than or equal to key
     * @param key
     * @return key 
     */
    public Key floor(final Key key) {
        int rank = rank(key);
        if (rank == 0) {
            return null;
        }
        if (rank < size && key.compareTo(keys[rank]) == 0) {
            return keys[rank];
        } else {
            return keys[rank - 1];
        }
    }

    public void deleteMin() {
        delete(min());
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(final Key key) {
        return get(key) != null;
    }
    /**
     * Delete method removes a particular key from Symbol table
     * @param key
     */
    public void delete(final Key key) {
        int rank = rank(key);
        if (rank == size || (keys[rank].compareTo(key) != 0)) {
            return;
        }
        for (int j = rank; j < size - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
        size--;
        keys[size] = null;
        values[size] = null;
    }

    public static void main(String[] args) {
        BinarySearchST<String,Integer> BSST = new BinarySearchST<>();
        BSST.put("Sai", 1);
        BSST.put("Kotesh", 1);
        System.out.println(Arrays.toString(BSST.keys));
    }
}