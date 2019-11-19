/**
 * @author SaiKotesh0102
 */
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import edu.princeton.cs.algs4.StdDraw;

public class FastCollinearPoints{
    private LineSegment[] lineSegments;

    public FastCollinearPoints(Point[] points){
        checkNull(points);
        Point[] sortedPoints = points.clone();
        Arrays.sort(sortedPoints);
        checkDuplicate(points);
        List<LineSegment> maxLineSegments = new LinkedList<>();

        for (int i = 0; i < points.length; i++) {
            Point p = sortedPoints[i];
            Point[] pointsBySlope = sortedPoints.clone();
            Arrays.sort(pointsBySlope, p.slopeOrder());

            int x = 1;
            while(x < points.length){
                LinkedList<Point> candidates = new LinkedList<>();
                double slopeRef = p.slopeTo(pointsBySlope[x]);

                do {
                    candidates.add(pointsBySlope[x++]);
                } while (x < points.length && p.slopeTo(pointsBySlope[x]) == slopeRef);

                if (candidates.size() >= 3 && p.compareTo(candidates.peek()) < 0) {
                    Point min = p;
                    Point max = candidates.removeLast();
                    maxLineSegments.add(new LineSegment(min, max));
                }
            }
        }
        lineSegments = maxLineSegments.toArray(new LineSegment[0]);
    }

    private void checkNull(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException();
        }
        for (Point p : points) {
            if (p == null) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkDuplicate(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].compareTo(points[i + 1]) == 0) {
                throw new IllegalArgumentException();
            }
        }
    }

    public int numberOfSegments(){
        return lineSegments.length;
    }

    public LineSegment[] segments(){
        return lineSegments.clone();
    }

}