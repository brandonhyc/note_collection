class Solution {
    public int minMeetingRooms(int[][] mts) {
        Arrays.sort(mts, (m1, m2) -> m1[0] - m2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((m1, m2) -> m1[1] - m2[1]);
        int maxNum = 0;
        for (int i = 0; i < mts.length; i++) {
            // System.out.printf(" mts[i]: %s\n", Arrays.toString(mts[i]));
            while (pq.size() != 0 && pq.peek()[1] <= mts[i][0]) {
                pq.poll();
            }
            pq.offer(mts[i]);
            maxNum = Math.max(pq.size(), maxNum);
        }
        return maxNum;
    }
}