public class ClassNameHere {
   public static class Solution {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
      public int search(int[] A, int target) {
         if ( A == null || A.length == 0) {
            return -1;
         }
         int start = 0, end = A.length -1;
         int rightEnd = A[end];
         while(start + 1 < end) {
            int mid = start + (end - start) /2;
            if(rightEnd > A[mid]) {
               end = mid;
            } else {
               start =mid;
            }
         }
         int lowestPoint;
         if ( A[start] < A[end]) {
            lowestPoint = start;
         } else {
            lowestPoint = end;
         }

         if(target <= A[A.length -1] ) {
            start = lowestPoint;
            end = A.length -1;
         } else {
            start = 0;
            end = lowestPoint - 1;
         }
         while (start + 1 < end) {
            int mid = start + (end - start) /2;
            if (target == A[mid]) {
               start = mid;
            } else if (target < A[mid]) {
               end = mid;
            } else {
               start = mid;
            }
         }

         if(A[start] == target) {
            return start;
         } 
         if(A[end] == target) {
            return end;
         }
         return -1;
      }
   }
   
   
   public static void main(String[] args) {
      //[1002,10203,9,10,100,101] 9
      int[] arr = {0,1,2,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1};
      int target = -9;
      Solution sol = new Solution();
      int result = sol.search(arr, target);
   }
}