class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x); 
        
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                
                maxHeap.offer(matrix[x][y]);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        
        return maxHeap.poll();
    }
}