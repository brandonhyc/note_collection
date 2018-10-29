public class Solution {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */

    public int[] kClosestNumbers(int[] A, int target, int k) {
        if (A == null ||  A.length ==0 || k == 0) return new int[0];
        if (target < 0 || k <= 0) return new int[0];

        
        // 1. find the closet number
        // 1 4 6 8
        int[] res = new int[k];
        int start = 0, end = A.length - 1;
        while(start < end - 1) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                start = mid;
            } else { end = mid; };
        }
        System.out.printf("start: %d, end: %d", start, end);

        // 2. seach from the start/end, left and right
        int count = 0;
        while (start >= 0 && end <= A.length - 1) {
            if (k == 0) break;
            if (Math.abs(target - A[start]) <= Math.abs(target - A[end])) {
                res[count] = A[start];
                start--; count++; k--;
            } else {
                res[count] = A[end];
                end++; count++; k--;
            }
        }

        while (start >= 0 && k > 0) {
            res[count] = A[start];
            start--; count++; k--;
        }

        while (end <= A.length - 1 && k >0) {
            res[count] = A[end];
            end++; count++; k--;
        }

        return res;
    }


}