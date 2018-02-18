public class Solution {
    /*
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
//17.02.2018

public int findPeak(int[] A) {
    // the second time
    if (A == null || A.length == 0) {
        return -1;
    }

    int start = 0, end = A.length -1;

    while (start + 1 < end) {
        int mid = start + (end - start) /2;
        if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1]) {
            start = mid;
        } else if ( A[mid - 1] > A[mid] && A[mid] < A[mid + 1]) {
            start = mid;
        } else if ( A[mid - 1] > A[mid] && A[mid] > A[mid + 1]) {
            end = mid;
        } else if ( A[mid -1] < A[mid] && A[mid] > A[mid + 1]) {
            start = mid;
        } else return -2;
    }

    if ( A[start] > A[end]){
        return start;
    }
    return end;
}
}