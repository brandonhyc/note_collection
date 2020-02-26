class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int imax = nums[0];
        int imin = nums[0];
        int maxp = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            // System.out.printf("imax: %d, imin: %d\n", imax, imin);
            maxp = Math.max(maxp, imax);
        }

        return maxp;
    }
}