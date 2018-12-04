public class Solution {
    /**
     * @param nums:  an array of n integers
     * @param target: a target
     * @return: the number of index triplets satisfy the condition nums[i] + nums[j] + nums[k] < target
     */
    public int threeSumSmaller(int[] nums, int target) {
        // Write your code here

        if (nums == null || nums.length < 3) {
            return 0;
        }

        int result = 0;

        Arrays.sort(nums);        
        for (int start = 0; start < nums.length - 2; start++) {
            
            int left = start + 1, right = nums.length - 1;
            while (left < right) {

                int sum = nums[start] + nums[left] + nums[right];
                
                if (sum < target) {
                    result += right - left;
                    left++;

                } else if (sum >= target) {
                    right--;
                }
            }
        }
        return result;
    }
}