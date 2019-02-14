class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
        if (K == 0) {
            return new int[1][1];
        }
        
        if (points.length == 0 || points[0].length == 0) {
            return new int[1][1];
        }

        int[][] results = new int[K][2];
        int[] distances = new int[points.length];

        for (int i = 0; i < points.length; i++) {
            distances[i] = computeDistance(new int[]{0, 0}, points[i]);
        }

        Arrays.sort(distances);

        int distanceK = distances[K - 1];

        int t = 0;
        for (int i = 0; i < points.length; i++) {
            if (distanceK >= computeDistance(new int[]{0, 0}, points[i])) {
                result[t] = points[i];
                t++;
            }
        }

    }

    private int computeDistance (int[] origin, int[] point) {
        
        return (Math.pow((point[0] - origin[0]), 2) + Math.pow((point[1] - origin[1]), 2));
    }
}