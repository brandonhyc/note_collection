public class Solution {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        // write your code here

        Set<Integet> set = new HashSet<>();

        int count = 0, left = 0, right = 0;

        for (int i = 0; i < nums.length; i++) {
            
            if (!set.contains(nums[right])) {
                set.add(nums[right]);
                nums[left] = nums[right];
                left++; count++;
            }
            right++;
        }
        return count;
    }
}