public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {

        if (A.length == 0) {
            return;
        }
        for (int i = A.length / 2; i >= 0; i--) {
            siftDown(A, i);
        }
    }

    private void siftDown(int[] A, int k) {
        while (k < A.length) {
            int smallest = k;

            if (k * 2 + 1 < A.length && 
                A[k * 2 + 1] < A[smallest]) {
                smallest = k * 2 + 1;
            }
            if (k * 2 + 2 < A.length &&
                A[k * 2 + 2] < A[smallest]) {
                smallest = k * 2 + 2;
            }
            if (smallest == k) {
                break;
            }
            int temp = A[smallest];
            A[smallest] = A[k];
            A[k] = temp;

            k = smallest;
        }
    }
}