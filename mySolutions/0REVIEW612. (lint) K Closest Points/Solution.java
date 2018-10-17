/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */

    private Point origin;
    private int size;
    public Point[] kClosest(
                    Point[] points, 
                    Point origin, 
                    int k) {
        // write your code here
        if (points == null || points.length == 0) {
            return points;
        }

        this.origin = origin;
        heapify(points);

        Point[] results = new Point[k];
        for (int i = 0; i < k; i++) {
            results[i] = pop(points);
        }
        return results;
    }

    private void heapify(Point[] points) {
        size = points.length;

        for (int i = size / 2; i >= 0; i--) {
            siftDown(points, i);
        }
    }

    private void siftDown(Point[] points, int index) {

        while(index < size) {
            int min = index;
            int left = index * 2 + 1;
            int right = index * 2 + 2;

            if (left < size &&
                compare(points[min], points[left]) > 0) {
                min = left;
            }
            if (right < size &&
                compare(points[min], points[right]) >0){
                min = right;
            }
            if (index != min) {
                Point temp = points[index];
                points[index] = points[min];
                points[min] = temp;
                index = min;
            } else{
                break;
            }
        }
    }

    private Point pop(Point[] points) {
        Point top = points[0];
        points[0] = points[size - 1];
        this.size--;

        siftDown(points, 0);
        return top;
    }


    private int compare(Point a, Point b) {
        int square = distanceSquare(a, origin) - distanceSquare(b, origin);
        if (square != 0) {
            return square;
        }
        if (a.x != b.x) {
            return a.x - b.x;
        }
        return a.y - b.y;
    }

    private int distanceSquare(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

}