class Solution {
    public int findMin(int[] arr) {

        int n = arr.length;
        int left = 0;
        int right = n - 1;

        int key = arr[n - 1];

        if (arr[left] <= arr[right]) {
            return arr[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > key) {
                left = mid + 1;
            } else if (arr[mid] == key) {
                right = mid;
                System.out.printf("error\n");
            } else if (arr[mid] < key) {
                right = mid;
            }
        }

        return Math.min(arr[left], arr[right]);

    }
}