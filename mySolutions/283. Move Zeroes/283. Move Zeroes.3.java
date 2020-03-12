class Solution {
    public void moveZeroes(int[] nums) {
        
        int i = 0; // cursor
        int j = 0; // [0, j) are non zero, from 0 to j (exclusively) are not zero 
        while (j < nums.length && nums[j] != 0) j += 1;
        i = j;
        while (i < nums.length) {
            if (nums[i] == 0) i += 1;
            else { // swap with 0
                nums[j] = nums[i];
                nums[i] = 0;
                i += 1;
                j += 1;
            }
        }
    }
}