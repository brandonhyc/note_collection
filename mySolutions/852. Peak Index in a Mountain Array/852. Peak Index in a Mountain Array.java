class Solution {
    public int peakIndexInMountainArray(int[] A) {

        int n = A.length;
        int left = 0;
        int right = n - 1;
           
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (A[mid] < A[mid + 1]) {
                left = mid + 1;        
            }
            else {
                right = mid - 1; 
            }    
        }
        
        if (A[left] > A[right]) {
            return left;
        }
        return right;
    }
}