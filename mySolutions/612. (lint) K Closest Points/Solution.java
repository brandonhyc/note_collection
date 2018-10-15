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

        Points[] results = new Point[k];

        for (int i = 0; i < k; i++) {
            results[i] = pop(points);
        }

        return results;
    }

    private void heapify(Point[] points) {
        size = points.length;
        for (int i = size /2; i >= 0; i--) {
            siftDown(points, i);
        }
    }

    private void siftDown(Point[] points, int index) {
        while (index < size) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int min = index;
            if ()
        }
    }

}