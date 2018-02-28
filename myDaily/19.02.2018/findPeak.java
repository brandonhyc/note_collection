public int findPeak(int[] A) {
    if (A == null || A.length == null) {
        return null;
    }

    int start = 0, end = A.length - 1;
    while (start + 1 < end) {
        int mid = start + (end - start);
        if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1]) {
            start = mid;
        } else if (A[mid - 1] > A[mid] && A[mid] > A[mid + 1]) {
            end = mid;
        } else if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
            return mid;
        }

        if (A[start] > A[end]) {
            return start;
        }
        return end;

    }

}