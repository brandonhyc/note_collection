// 思路: 首先要想subarray sum. 0 意味着后来的subarraySum = 0;
// 把它如此处理就是 


public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // write your code here

        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        if (nums.length < 2 || nums == null) {
            result.add(0);
            return result;
        }
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum)) {
                int start = map.get(sum) + 1;
                int end = i;

                result.add(start);
                result.add(end);

                return result;
            }
            map.put(sum, i);
        }
        return result;

    }
}