import java.util.*;
import java.lang.*;

public class BinarySearchST{
    private String[] keys;
    private int[] values;
    private int size;

    public BinarySearchST(){
        this.keys = new String[2];
        this.values = new int[2];
        this.size = 0;
    }

    private void resize() {
        keys = Arrays.copyOf(keys, size + 1);
        values = Arrays.copyOf(values, size + 1);
    }

    public void put(final String key, final int value) {
        if (value == 0) {
            delete(key);
            return;
        }
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

    public int get(final String key) {
        int rank = rank(key);
        if (rank < size && (keys[rank].compareTo(key) == 0)) {
            return values[rank];
        }
        return 0;
    }

    public int rank(final String key){
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

    public String max() {
        return keys[size - 1];
    }

    public String min() {
        return keys[0];
    }

    public String floor(final String key) {
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

    public boolean contains(final String key) {
        return get(key) != 0;
    }

    public void delete(final String key) {
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
        values[size] = 0;
    }

    public void keys() {
        for (int i = 0; i < size; i++) {
            System.out.println(keys[i] + " " + values[i]);
        }
    }
}