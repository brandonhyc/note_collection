class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
        if (k == 0) {
            return new int[1][1];
        }
        
        if (points.length == 0 || points[0].length == 0) {
            return new int[1][1];
        }

        int[][] results = new int[K][2];
        int[] distances = new int[points.length];

        for (int i = 0; i < points.length; ++) {
            distances[i] = computeDistance(points[i]);
        }

        Arrays.sort(distances);

        int distanceK = distances[K - 1];

        for (int i = 0; i < points.length; i++) {
            if (distanceK >= computeDistance([0, 0], points[i])) {
                
            }
        }

    }

    private int computeDistance (int[] origin, int[] point) {
        
        return ((point[0] - origin[0])**2 + (point[1] - origin[1])**2);
    }
}