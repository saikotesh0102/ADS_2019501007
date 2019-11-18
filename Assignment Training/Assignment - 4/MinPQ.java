/**
 * @author SaiKotesh0102
 */

import java.util.*;

public class MinPQ<Key extends Comparable<Key>>{
    private Key[] pq;
    private int n;

    public MinPQ(final int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty() {
        if (n == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return n;
    }

    public void insert(final Key key) {
        pq[++n] = key;
        swim(n);
    }

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    public Key min() {
        return pq[1];
    }

    public Key delMin() {
        Key min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        return min;
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private boolean greater(final int i, final int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void exch(final int i, final int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public static void main(String[] args) {
        MinPQ<Integer> minPQ = new MinPQ(7);
        MaxPQ<Integer> maxPQ = new MaxPQ(7);
        minPQ.insert(2);
        minPQ.insert(4);
        minPQ.insert(8);
        minPQ.insert(6);
        minPQ.insert(7);
        minPQ.insert(10);
        minPQ.insert(9);

        maxPQ.insert(2);
        maxPQ.insert(4);
        maxPQ.insert(8);
        maxPQ.insert(6);
        maxPQ.insert(7);
        maxPQ.insert(10);
        maxPQ.insert(9);

        minPQ.delMin();
        minPQ.delMin();
        minPQ.delMin();

        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());

        System.out.println(Arrays.toString(minPQ.pq));
    }
}