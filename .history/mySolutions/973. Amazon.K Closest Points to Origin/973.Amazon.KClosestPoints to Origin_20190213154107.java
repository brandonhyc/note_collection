class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
        if (k == 0) {
            return new int[1][1];
        }
        
        if (points.length == 0 || points[0].length == 0) {
            return new int[1][1];
        }

        int[] dists = new int[points.length];
        
        for (int i = 0; i < points.length; i++) {
            dists[i] = computeDistance(points[i]);
        }

        Arrays.sort(dists);
        int distK = dists[K - 1];


    }
    
    public int computeDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}