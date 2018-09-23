// 易错点1: 分不清 i 还是 startIndex
// helper(nums, results, startIndex + 1, subset);
// 正确为helper(nums, results, i + 1, subset);

// 思路: 
// 要想如何处理重复的情况. 例如: [1,2,2], 重复的情况是: [1, 2a], [1, 2b]
// 若采取去掉[1, 2b]的方法, 则是在 [1] --> [1, 2a] -->3. [1] --> 4. [1, 2b] 在3->4间continue.
// 那么, 3->4的特征是 a. 前后两项相同, 是即将加入的字符(i)和上一个字符(i - 1)相同. 
// b. 这种情况发生在 [1, _, 2b], 上一次加入字符1 后, 空了一个字符, 才再加入字符2. 在该层循环里面(i = 3), 
//  而最后一次加入的字符1 便是 startIndex所指向的字符 

public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();

        if (nums.length == 0) {
            results.add(new ArrayList<>());
            return results;
        }

        Arrays.sort(nums);

        helper(nums, results, 0, new ArrayList<>());

        return results;
    }

    private void helper(int[] nums, 
                        List results, 
                        int startIndex, 
                        List subset) {
        
        results.add(new ArrayList<>(subset));
        
        for (int i = startIndex; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && i > startIndex){
                continue;
            }
            subset.add(nums[i]);
            helper(nums, results, i + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }
}


