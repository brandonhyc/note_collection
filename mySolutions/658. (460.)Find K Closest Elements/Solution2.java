public class Solution {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here

        if (A == null || A.length == 0) {
            return new int[]{};
        }

        List<Integer> list = new ArrayList<>();

        int start = 0, end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (target == A[mid]) {
                end = mid;
            }

            if (A[mid] < target) {
                start = mid;
            }
            if (target < A[mid]) {
                end = mid;
            }
        }

        int left = start, right = start + 1;

        if (Math.abs(A[start] - target) > Math.abs(A[end] - target)) {
            left = end;
            right = end + 1;
        }

        while (left >= 0 && right < A.length && k > 0) {
            if (Math.abs(A[left] - target) <= Math.abs(A[right] - target)) {
                list.add(A[left]);
                left--;
                k--;
            } else if (Math.abs(A[left] - target) > Math.abs(A[right] - target)) {
                list.add(A[right]);
                right++;
                k--;
            }
        }

        while (k > 0 && left >= 0) {
            list.add(A[left]);
            k--;
            left--;
        }

        while (k > 0 && right < A.length) {
            list.add(A[right]);
            k--;
            right++;
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}