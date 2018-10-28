class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] result = new int[2];
        result[0] = searchFirst(nums, target);
        result[1] = searchLast(nums, target);

        return result;
    }

    private int searchFirst(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                end = mid;
            }
            if (nums[mid] < target) {
                start = mid;
            }
            if (target < nums[mid]) {
                end = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }

    private int searchLast(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                start = mid;
            }
            if (nums[mid] < target) {
                start = mid;
            }
            if (target < nums[mid]) {
                end = mid;
            }
        }
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
}