    //18.02.2018
    public int search(int[] A, int target){
        if (A == null || A.length == 0) {
            return -1;
        }
        int start =0, end = A.length - 1;
        int left = A[0], right = A[A.length - 1];
        while (start + 1 < end) {
            int mid = start + (end - start) /2;
            if (A[mid] <= right){
                end = mid;
            } else {
                start = mid;
            }
        }
    
        int lowest;
        if (A[start] < A[end]){
            lowest = start;
        } else {
            lowest = end;
        }
    
        // found lowest point
    
        if ( target <= A[A.length - 1]) {
            start = lowest;
            end = A.length -1;
        } else {
            start = 0;
            end = lowest;
        }
        left = A[start];
        right = A[end];
        while ( start + 1 < end ) {
            int mid = start + (end - start) /2;
            if(target == A[mid]) {
                start = mid;
            } else if (target < A[mid]) {
                end = mid;
            } else if (A[mid] < target) {
                start = mid;
            }
        }
    
        if (A[start] == target) {
            return start;
        }
    
        if (A[end] == target) {
            return end;
        }
    
        return -1;
    
    }