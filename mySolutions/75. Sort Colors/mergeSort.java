public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] array = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, array);
        
    }
    private void mergeSort(int[] A, int start, int end, int[] array) {
        if (start >= end) {
            return;
        }
        int left = start, right = end;
        int mid = (start + end) / 2;

        mergeSort(A, start, (start + end) / 2, array);
        mergeSort(A, (start + end) / 2 + 1, end, array);
        merge(A, start, end, array);
    }

    private void merge(int[] A, int start, int end, int[] array) {
        int mid = (start + end) / 2;
        int left = start;
        int right = mid + 1;
        int index = left;

        while (left <= mid && right <= end) {
            if (A[left] < A[right]) {
                array[index] = A[left];
                index++;
                left++;
            } else {
                array[index] = A[right];
                index++;
                right++;
            }
        }

        while (left <= mid) {
            array[index] = A[left];
            index++;
            left++;
        }
        
        while (right <= end) {
            array[index] = A[right];
            index++;
            right++;
        }
        
        for (index = start; index <= end; index++) {
            A[index] = array[index];
        }
    }
}