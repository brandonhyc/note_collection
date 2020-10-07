public class Solution {
    public int minMeetingRooms(int[][] intervals) {
      Arrays.sort(intervals, new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
          return Integer.compare(a[0], b[0]);
        }
      });
      PriorityQueue<int[]> ongoing = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
          return Integer.compare(a[1], b[1]);
        }
      });
  
      int max = 0;
      for (int i = 0; i < intervals.length; i++) {
        while (!ongoing.isEmpty() && ongoing.peek()[1] <= intervals[i][0]) {
          ongoing.poll();
        }
        ongoing.offer(intervals[i]);
        max = Math.max(max, ongoing.size());
      }
      return max;
    }
  }
  