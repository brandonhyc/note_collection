class Solution {
    public int search(int[] arr, int key) {
        if (arr.length == 0) {
            return -1;
        }
        // find the min

        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                return mid;
            }

            if (arr[left] <= arr[mid]) {
                // left half is sorted correctly
                if (key >= arr[left] && key < arr[mid]) { // key is in sorted range
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // right half is sorted
                if (key > arr[mid] && key <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}