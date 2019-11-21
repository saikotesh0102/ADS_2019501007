/**
 * @author SaiKotesh0102
 */
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import edu.princeton.cs.algs4.StdDraw;
/**
 * Fast Collinear points class implements the same as the Brute Collinear Points
 * we sort the points based on the slope and find if the points are collinear or not.
 */
public class FastCollinearPoints{
    private LineSegment[] lineSegments;
    /**
     * Method to sort the points based on their value.
     * Take the Initial point as reference and sort the points based on the slope.
     * @param points
     */
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
    /**
     * Method to check whether the points are null or not
     * if null throw an illegal argument exception
     * @param points
     */
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
    /**
     * mrthod to check whether there are duplicate elements or not
     * @param points
     * @return true if there are.
     */
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
    /**
     * method to count the number of line segments
     * @return the count
     */
    public int numberOfSegments(){
        return lineSegments.length;
    }
    /**
     * Method to find the line segments formed
     * @return the Line segments.
     */
    public LineSegment[] segments(){
        return lineSegments.clone();
    }

}