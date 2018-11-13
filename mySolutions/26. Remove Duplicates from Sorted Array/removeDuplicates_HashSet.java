public class Solution {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int result = 0;

        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }

        int size = set.size();
        Iterator<Integer> it = set.iterator(); 
        
        for (int i = 0; i < size; i++) {
            nums[i] = it.next();
        }
        return size;
    }
}