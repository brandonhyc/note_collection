class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        
        
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1) {
                i++;
            }
            else if (nums[i] - 1 >= 0 && nums[i] - 1 < nums.length && nums[i] == nums[nums[i] - 1]) {
                i++;
            }
            else if (nums[i] - 1 >= 0 && nums[i] - 1 < nums.length) { // can swap
                swap(nums, i, nums[i] - 1);
            }
            else {
                i++;
            }
        }
        
        System.out.println(Arrays.toString(nums));
        
        i = 1;
        while (i - 1 < nums.length && i == nums[i - 1]) {
            i++;
        }
        return i;
        
    }
    private void swap(int[] nums, int left, int right) {

        int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;        
    
    }
}