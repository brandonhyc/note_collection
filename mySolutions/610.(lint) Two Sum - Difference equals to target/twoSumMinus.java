public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0, right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            // case: nums[1] = 
            if (map.containsKey(nums[i])) {
                int a = map.get(nums[i]) < i ? map.get(nums[i]) : i;
                int b = map.get(nums[i]) < i ? i : map.get(nums[i]);
                return new int[]{ a + 1, b + 1 };
            }

            // nums[1] - nums[2] = target ;
            // need: 
            map.put(nums[i] + target, i);
            map.put(nums[i] - target, i);
        }
        return new int[] {-1, -1};
    }
}