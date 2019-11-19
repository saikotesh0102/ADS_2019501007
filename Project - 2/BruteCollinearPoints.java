/**
 * @author SaiKotesh0102
 */
import java.util.Arrays;
import edu.princeton.cs.algs4.StdDraw;

public class BruteCollinearPoints{
    private Point[] points;
    private LineSegment[] lineSegments;
    private int lineSegmentCount;

    public BruteCollinearPoints(Point[] points){
        checkPoints(points);

        this.points = points;
        this.lineSegments = new LineSegment[2];
        this.lineSegmentCount = 0;

        Arrays.sort(this.points);

        for (int i = 0; i < this.points.length; i++){
            for (int j = i + 1; j < this.points.length; j++) {
                for (int k = j + 1; k < this.points.length; k++) {
                    for (int l = k + 1; l < this.points.length; l++) {
                        if(this.points[i].slopeTo(this.points[j]) == this.points[j].slopeTo(this.points[k]) && this.points[j].slopeTo(this.points[k]) == this.points[k].slopeTo(this.points[l])){
                            add(new LineSegment(this.points[i],this.points[j]));
                            this.points[i].drawTo(this.points[l]);
                            StdDraw.show();
                        }
                    }
                }
            }
        }
    }

    private void add(LineSegment line){
        if(line == null){
            throw new IllegalArgumentException();
        }

        if(this.lineSegmentCount == this.lineSegments.length){
            resize(2 * this.lineSegments.length);
        }

        this.lineSegments[this.lineSegmentCount++] = line;
    }

    private void resize(int capacity){
        assert capacity >= this.lineSegmentCount;

        LineSegment[] temp = new LineSegment[capacity];
        System.arraycopy(this.lineSegments, 0, temp, 0, this.lineSegmentCount);
        this.lineSegments = temp;
    }

    private void checkPoints(Point[] points){
        if(points == null){
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if(points[i] == null || points[j] == null){
                    throw new IllegalArgumentException();
                }

                if(i != j && points[i].compareTo(points[j]) == 0){
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    public int numberOfSegments(){
        return this.lineSegmentCount;
    }

    public LineSegment[] segments(){
        return Arrays.copyOf(this.lineSegments, this.lineSegmentCount);
    }
}