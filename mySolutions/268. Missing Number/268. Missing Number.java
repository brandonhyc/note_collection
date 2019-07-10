class Solution {
    public int missingNumber(int[] nums) {

        int i = 0;
        int result = 0;
        for (i = 0; i < nums.length; i++) {
            result = result ^ i ^ nums[i];
        }
        result = result ^ 0;
        return result ^ i;

    }
}