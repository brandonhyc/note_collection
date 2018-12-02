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

        List<List<Integer>> results = new ArrayList<>();
        Map<Integer, int[]> map = new HashMap<>();

        Arrays.sort(nums);

        for (int start = 0; start < nums.length - 2; start++) {

            int target = -nums[start];

            int left = start + 1, right = nums.length - 1;

            while (left < right) {

                if (nums[left] + nums[right] == target) {
                    List<Integer> result = new ArrayList(Arrays.asList(
                            nums[start], nums[left], nums[right]
                    ));
                    results.add(result);
                } 
                if (nums[left] + nums[right] < target) {
                    left++;
                    while (left < right && nums[left - 1] == nums[left]) {
                        left++;
                    }

                } else {
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
            // skip the same results
            while (start + 1 < nums.length - 2 && nums[start + 1] == nums[start]) {
                start++;
            }
        }        
        return results;
    }
}