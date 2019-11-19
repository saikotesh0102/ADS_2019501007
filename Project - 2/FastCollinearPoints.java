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
        if(checkDuplicate(points)){
            throw new IllegalArgumentException();
        }
        List<LineSegment> maxLineSegments = new LinkedList<>();

        for (int i = 0; i < points.length; i++) {
            Point p = sortedPoints[i];
            Point[] pointsBySlope = sortedPoints.clone();
            Arrays.sort(pointsBySlope, p.slopeOrder());

            int x = 1;
            while(x < points.length){
                LinkedList<Point> clusterPoints = new LinkedList<>();
                double slopeRef = p.slopeTo(pointsBySlope[x]);

                do {
                    clusterPoints.add(pointsBySlope[x++]);
                } while (x < points.length && p.slopeTo(pointsBySlope[x]) == slopeRef);

                if (clusterPoints.size() >= 3 && p.compareTo(clusterPoints.peek()) < 0) {
                    Point min = p;
                    Point max = clusterPoints.removeLast();
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

    private boolean checkDuplicate(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].compareTo(points[j]) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public int numberOfSegments(){
        return lineSegments.length;
    }

    public LineSegment[] segments(){
        return lineSegments.clone();
    }

}