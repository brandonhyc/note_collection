class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (slow < 2 || nums[slow - 2] < nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            
        }
        return slow;
    }
}