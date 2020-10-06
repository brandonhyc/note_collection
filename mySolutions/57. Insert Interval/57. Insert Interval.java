class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> list = new ArrayList<>();
        // find the insert position
        int i = 0;
        while (i < intervals.length && intervals[i][0] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
            // skip all starts before new interval
        }
        if (i - 1 >= 0 && list.get(i - 1)[1] >= newInterval[0]) {
            // no overlaps to the left interval
            int[] last = list.remove(i - 1);
            newInterval[0] = Math.min(last[0], newInterval[0]);
            newInterval[1] = Math.max(newInterval[1], last[1]);
        } 
        
        while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
            // merge all the next intervals if possible
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        
        list.add(newInterval);
        while (i < intervals.length) {
            list.add(intervals[i++]);
        }
        
        int[][] res = new int[list.size()][2];
        for (i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        
        
        return res;
    }
}