class Solution {
    public int findPairs(int[] nums, int k) {
        

        if (nums == null || nums.length == 0) {
            return -1;
        }

        Array.sort(nums);
        int result = 0;
        int left = 0, right = nums.length - 1;

        while (left < right) {
            while (left < right 
                    && left + 1 < nums.length 
                    && nums[left] == nums[left + 1]) {
                left++;
            }

            while (left < right 
                    && right - 1 > 0  
                    && nums[right] == nums[right - 1]) {
                right--;
            }

            if (nums[left] + nums[right] == k) {
                result++;

            }
            
            left--;
            right++;
        }

    }
}