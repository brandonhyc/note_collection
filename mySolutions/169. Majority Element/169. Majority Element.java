class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        
        int count = 1;
        int num = nums[0];
        
        for (int i = 1; i < nums.length; i ++) {
            if (num == nums[i]) {
                count++;
            } else if (num != nums[i] && count == 0) {
                count = 1;
                num = nums[i];
            } else {
                count--;
            }
        }
        return num;
        
    }
}