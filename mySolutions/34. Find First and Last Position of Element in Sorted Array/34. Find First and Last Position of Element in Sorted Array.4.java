class Solution {
    public int[] searchRange(int[] num, int target) {
        // [5,7,7,8,8,10], target = 8
        // start: find the smallest number >= target 8 
        // end - 1: find the smallest number > target 8

        int[] result = new int[]{-1, -1};
        int n = num.length;
        int left = 0;
        int right = n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (num[mid] == target) {
                right = mid - 1;
            }
            else if (num[mid] < target) {
                left = mid + 1;
            }
            else if (num[mid] > target) {
                right = mid - 1;
            }
        }
        if (left < n && num[left] == target) {
            result[0] = left;
        }
        
        left = 0;
        right = n - 1;
        
        // end - 1: find the smallest number > target 8
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (num[mid] == target) {
                left = mid + 1;
            }
            else if (num[mid] < target) {
                left = mid + 1;
            }
            else if (num[mid] > target) {
                right = mid - 1;
            }
        }
        
        if (right >= 0 && num[right] == target) {
            result[1] = right;
        }
        
        return result;
    }
}