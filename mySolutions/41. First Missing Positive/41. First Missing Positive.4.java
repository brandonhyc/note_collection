class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - 1 != i && nums[i] - 1 >= 0 && nums[i] - 1 < nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        int j = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != j) {
                break;
            }
            j++;
        }

        return j;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}