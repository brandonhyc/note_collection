class Solution {
    public int connectSticks(int[] sticks) {
        
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        
        for (int num : sticks) {
            minheap.offer(num);
        }
        
        int total = 0;
        while (minheap.size() >= 2) {
            int num1 = minheap.poll();
            int num2 = minheap.poll();
            
            int sum = num1 + num2;
            minheap.offer(sum);
            total += sum;
        }
        
        return total;
    }
}