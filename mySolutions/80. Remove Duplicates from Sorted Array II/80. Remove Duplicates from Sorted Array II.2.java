class Solution {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int slow = 0;
        // [1,1,1,2,2,3]
        boolean haveTwoAlready = false;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast - 1]) {
                // if have new, move on and replace
                slow++;
                nums[slow] = nums[fast];
                haveTwoAlready = false;
            } else if (!haveTwoAlready) {
                // move on and replace, set flag
                slow++;
                nums[slow] = nums[fast];
                haveTwoAlready = true;
            }
        }

        return slow + 1;
    }
}