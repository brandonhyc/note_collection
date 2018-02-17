public int findPeak(int[] A) {
    if (A == null || A.length ==0) {
        return -1;
    }
    int start = 0, end = A.length -1;
    while (true) {
        int mid = start + (end - start) /2;
        if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1]){
            start = mid;
        } else if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1]){
            return mid;
        } else if (A[mid - 1] > A[mid] && A[mid] < A[mid + 1]) {
            start = mid;
        } else if (A[mid - 1] > A[mid] && A[mid] > A[mid + 1]){
            end = mid;
        } else {
            return -1;
        }
    }
    //4 kinds: // /\ \/ \\ 


}