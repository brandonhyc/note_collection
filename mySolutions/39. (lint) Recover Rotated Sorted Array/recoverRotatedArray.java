public class Solution {
    /**
     * @param nums: An integer array
     * @return: nothing
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here

        if (nums == null || nums.size() == 0) {
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (i + 1 < nums.size() && nums.get(i) < nums.get(i + 1)) {
                continue;
            }
            if (i + 1 < nums.size() && nums.get(i) > nums.get(i + 1)) {
                
                reverse(nums, 0, i);
                reverse(nums, i + 1, nums.size() - 1);
                reverse(nums, 0, nums.size() - 1);
            }
        }
    }

    private void reverse(List<Integer> nums, int left, int right) {
        while (left >= 0 && 
                right < nums.size() && 
                left < right) {
            int temp = nums.get(left);
            nums.set(left, nums.get(right));
            nums.set(right, temp);
            left++; right--;
        }
    }
}