public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {

            // get i's value, that is nums[i], and move that to i - 1
            // index 1 -> 2
            while (nums[i] - 1 >= 0 && nums[i] - 1 < nums.length && nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1]) {
                    // for [1,1] edge case
                    break;
                }

                swap(nums, i, nums[i] - 1);
                // System.out.printf("%s\n", Arrays.toString(nums));

            }
            // System.out.printf("%s\n", Arrays.toString(nums));
        }

        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != result) {
                break;
            }
            result++;
        }

        return result;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}