public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // write your code here
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, int[]> map = new HashMap<>();

        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;
        int target = 0;

        while (left < right) {
            while (left + 1 < right && nums[left] == nums[left + 1]) {
                left++;
            }
            while (left < right - 1 && nums[right] == nums[right - 1]) {
                right--;
            }
            if (map.containsKey(nums[left] + nums[right])) {
                right = left;
            }
            map.put(target - (nums[left] + nums[right]), {left, right});

            if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            }
            

        }

    }
}