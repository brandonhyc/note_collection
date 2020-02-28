class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums.length == 0)
            return 0;

        int aCount = 0;
        int l = 0;
        int curProd = 1;

        for (int r = 0; r < nums.length; r++) {
            curProd *= nums[r];

            while (curProd >= k && l < r) {
                curProd /= nums[l];
                l += 1;
            }

            if (curProd < k)
                aCount += r - l + 1;
            // System.out.printf("left: %d, right: %d, aCount: %d\n", l, r, aCount);
        }

        return aCount;

    }
}