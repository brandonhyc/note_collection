class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int index = nums.length - 2;
        while (index >= 0) {
            if (nums[index] < nums[index + 1]) {
                break;
            }
            index -= 1;
        }
        
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        int sink = index;
        // System.out.printf("sink: %d\n", sink);
        int higher = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[sink]) {
                higher = i;
                break;
            }
        }
        // System.out.printf("higher: %d\n", higher);

        int temp = nums[sink];
        nums[sink] = nums[higher];
        nums[higher] = temp;
        // System.out.printf("after swap nm : %s\n", Arrays.toString(nums));
        reverse(nums, sink + 1, nums.length - 1);
        
        return;
    }
    
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left += 1;
            right -= 1;
        }
    }
}