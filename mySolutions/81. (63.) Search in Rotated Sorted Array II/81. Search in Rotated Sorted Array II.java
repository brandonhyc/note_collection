class Solution {
    public boolean search(int[] arr, int key) {

        int n = arr.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == key) {
                return true;
            } else if (arr[mid] == arr[left] && arr[left] == arr[right]) {
                left += 1;
                right -= 1;
            } else if (arr[left] <= arr[mid]) {
                // left half is sorted
                if (key >= arr[left] && key < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (key > arr[mid] && key <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;

    }
}