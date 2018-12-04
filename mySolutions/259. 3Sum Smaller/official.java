public class Solution {
    /**作者： 千秋无痕
     * @param nums:  an array of n integers
     * @param target: a target   
     * @return: the number of index triplets satisfy the condition nums[end] + nums[j] + nums[k] < target
     */
    public int threeSumSmaller(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length < 3) {
            return 0;
        }
        
        int count = 0;
        Arrays.sort(nums);
        
        for (int end = 2; end < nums.length; ++end) {
            int left = 0, right = end - 1;
            for (; left < right; ++left) {
                while (left < right && nums[end] + nums[left] + nums[right] >= target) {
                    right--;
                }
                if (left < right && nums[end] + nums[left] + nums[right] < target) {
                    count += right - left;
                }
            }
        }
        return count;
    }
}