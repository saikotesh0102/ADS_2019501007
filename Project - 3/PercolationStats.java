/**
 * @author SaiKotesh0102
 */
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class PercolationStats{
    private Percolation per;
    private double[] values;
    private int count;
    private double mean;
    private double stdDev;

    public double mean(){
        mean = StdStats.mean(values);
        return mean;
    }

    public double stddev(){
        stdDev = StdStats.stddev(values);
        return stdDev;
    }

    public double confidenceHi(){
        return mean + ((1.96 * stdDev) / Math.sqrt(count));
    }

    public double confidenceLo(){
        return mean - ((1.96 * stdDev) / Math.sqrt(count));
    }

    public PercolationStats(int n, int trials){
        if(n <= 0 || trials <= 0){
            throw new IllegalArgumentException();
        }

        count = trials;
        values = new double[count];
        for (int i = 0; i < count; i++) {
            per = new Percolation(n);
            int sitesOpen = 0;

            while(! per.percolates()){
                int j = StdRandom.uniform(1, n + 1);
                int k = StdRandom.uniform(1, n + 1);

                if (!per.isOpen(j, k)) {
                    per.open(j, k);
                    sitesOpen++;
                }
            }
            double value = (double) sitesOpen/(n * n);
            values[i] = value;
        }
    }

    public static void main(String[] args) {
        
    }
}