/**
 * @author SaiKotesh0102
 */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation{
    private boolean[][] grid;
    private int start;
    private int end;
    private int size;
    private int sitesOpen;
    private WeightedQuickUnionUF wq;

    public Percolation(int n){
        if(n <= 0){
            throw new IllegalArgumentException();
        }

        size = n;
        end = size * size + 1;
        wq = new WeightedQuickUnionUF(size * size + 2);
        grid = new boolean[size][size];
    }

    public void open(int row, int col){
        if (row > 0 && row <= size && col > 0 && col <= size) {
            if(grid[row-1][col-1]){
                return;
            }
            grid[row - 1][col - 1] = true;
            sitesOpen = sitesOpen + 1;

            if (row == 1) {
                wq.union(get1DPosition(row, col), start);
            }

            if (row == size) {
                wq.union(get1DPosition(row, col), end);
            }

            if (col > 1 && isOpen(row, col - 1)) {
                wq.union(get1DPosition(row, col), get1DPosition(row, col - 1));
            }

            if (col < size && isOpen(row, col + 1)) {
                wq.union(get1DPosition(row, col), get1DPosition(row, col + 1));
            }

            if (row > 1 && isOpen(row - 1, col)) {
                wq.union(get1DPosition(row, col), get1DPosition(row - 1, col));
            }

            if (row < size && isOpen(row + 1, col)) {
                wq.union(get1DPosition(row, col), get1DPosition(row + 1, col));
            }
        }else {
            throw new IllegalArgumentException();
        }
    }

    private int get1DPosition(int row, int col) {
        return size * (row - 1) + col;
    }

    public boolean isOpen(int i, int j) {
        if (i > 0 && i <= size && j > 0 && j <= size) {
            return grid[i-1][j-1];
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int numberOfOpenSites(){
        return sitesOpen;
    }

    public boolean isFull(int i, int j) {
        if (i > 0 && i <= size && j > 0 && j <= size) {
            return wq.connected(start, get1DPosition(i , j));
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean percolates() {
        return wq.connected(start, end);
    }

    public static void main(String[] args) {
        
    }
}