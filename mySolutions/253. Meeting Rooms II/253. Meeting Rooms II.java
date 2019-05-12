class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue(intervals.length, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return Integer.compare(a, b);
            }
        });
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        
        for (int i = 0; i < intervals.length; i++) {
            
            if (minHeap.peek() == null) {
                minHeap.add(intervals[i][1]);
            }
            else if (minHeap.peek() <= intervals[i][0]) {
                minHeap.poll();
                minHeap.add(intervals[i][1]);
            }
            else if (minHeap.peek() > intervals[i][0]) {
                minHeap.add(intervals[i][1]);
            }
            
            // System.out.println(Arrays.toString(minHeap.toArray()));
        }
        
        return minHeap.size();
    }
}