class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int[] results = new int[nums.length - k + 1];

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = nums[i];
        }

        for (int i = 0; i < results.length; i++) {
            for (int j = 0; j)
            

        }


    }
}