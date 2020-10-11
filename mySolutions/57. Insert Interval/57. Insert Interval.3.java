
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][] {newInterval};
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(intervals[i]);
        }

        int left = 0, right = intervals.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (intervals[mid][0] == newInterval[0]) {
                left = mid;
                break;
            } else if (intervals[mid][0] < newInterval[0]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int prev = left - 1, next = left;
        if (prev >= 0 && list.get(prev)[1] >= newInterval[0]) {
            newInterval[0] = list.get(prev)[0];
            newInterval[1] = Math.max(newInterval[1], list.get(prev)[1]);
            list.remove(prev);
            next = prev;
        }

        while (next < list.size() && newInterval[1] >= list.get(next)[0]) {
            newInterval[0] = Math.min(newInterval[0], list.get(next)[0]);
            newInterval[1] = Math.max(newInterval[1], list.get(next)[1]);
            list.remove(next);
        }

        list.add(next, newInterval);

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
