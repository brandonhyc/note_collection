public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        // write your code here 
        
        if (A.length == 0) {
            return;
        }
        for (int i = A.length / 2; i >= 0; i--) {
            siftup(A, i);            
        }
    }
    private void siftup(int[] A, int k) {
        while (2 * k + 1 < A.length) {
            
            int left = 2 * k + 1;
            int right = 2 * k + 2;
            int son = (2 * k + 2 < A.length) && (A[left] > A[right]) ? right : left;
            if (A[k] > A[son]) {
                int temp = A[k];
                A[k] = A[son];
                A[son] = temp;
            }
            k = son;
        }
    }
}