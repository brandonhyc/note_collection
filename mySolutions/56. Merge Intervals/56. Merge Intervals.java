class Solution {
    public int[][] merge(int[][] intervals) {
        
        
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return new int[0][0];
        }
        
        LinkedList<int[]> results = new LinkedList<>();
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            
            if (results.isEmpty()) {
                results.add(intervals[i]);
            }
            else if (results.getLast()[1] < intervals[i][0]) {
                // if no overlap (previous.end < next.start), add
                results.add(intervals[i]);
            }
            else if (results.getLast()[1] >= intervals[i][0]) {
                // if overlap, merge two intervals by extending the previous interval
                results.getLast()[1] = Math.max(results.getLast()[1], intervals[i][1]);
            }
    
        }
        
        int[][] resultsInArray = new int[results.size()][2];
        for (int i = 0; i < results.size(); i++) {
            resultsInArray[i] = results.get(i);
        }
        return resultsInArray;
    }
}