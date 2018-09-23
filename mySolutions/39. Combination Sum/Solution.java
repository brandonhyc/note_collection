
// 难点1: 可重复多次选择一个单元
// 思路: 一般情况下 helper(..., i + 1), 这样就, 在内层递归中, 指针指向下一个字符
//   但本题, 应该设为i. 这样指针就先停留在原字母上. 等价于 节点(i) + 树(i + 1)
//   除此以外, dfs如常规一样执行.  

public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        
        List<List<Integer>> results = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            results.add(new ArrayList<>());
            return results;
        }

        Arrays.sort(candidates);

        helper(candidates, target, results, 0, new ArrayList<>());

        return results;
 
    }

    private void helper(int[] candidates, 
                    int target, 
                    List results,
                    int startIndex, 
                    List comb) {
        
        if (target == 0) {
            results.add(new ArrayList<>(comb));
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;    
            }
            if (i > 0 && candidates[i] == candidates[i - 1] && i > startIndex) {
                continue;
            }
            
            comb.add(candidates[i]);
            helper(candidates, target - candidates[i], results, i, comb);
            comb.remove(comb.size() - 1);
        }
    }
}