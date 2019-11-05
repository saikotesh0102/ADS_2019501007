import java.util.*;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int n;

    public MaxPQ(final int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty() {
        if (n == 0) {
            return true;
        } else {
            return false;
        }
        // return true;
    }

    public void insert(final Key key) {
        pq[++n] = key;
        swim(n);
    }

    public Key max() {
        return pq[1];
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    public int size() {
        return n;
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private boolean less(final int i, final int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(final int i, final int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}