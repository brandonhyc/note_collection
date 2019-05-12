class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        boolean isValid = true;
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length; j++) {
                if (i == j) {
                    continue;
                }    
                if (intervals[i][1] <= intervals[j][0]
                 || intervals[i][0] >= intervals[j][1]) {
                    isValid = isValid && true;
                }
                else {
                    isValid = isValid && false;
                }   
            }    
        }
        return isValid;
    }
}