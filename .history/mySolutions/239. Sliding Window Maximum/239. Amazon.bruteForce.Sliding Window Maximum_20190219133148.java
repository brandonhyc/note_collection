class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int[] results = new int[nums.length - k + 1];

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < results.length; i++) {
            if (i == 0) {
                for (int j = 0; j < k; j++) {
                    list.add(nums[j]);
                }
            } else {
                list.remove(list.get(0));
                list.add((Integer) nums[i + k - 1]);
            }

            int max = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                max = Math.max(max, list.get(j));
            }
            results[i] = max;
        }
        return results;

    }
}