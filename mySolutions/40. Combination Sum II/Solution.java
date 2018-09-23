public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        
        if (num == null || num.length == 0) {
            return results;
        }
        
        Arrays.sort(num);

        helper(num, target, results, 0, new ArrayList<>());
        return results;
    }

    private void helper(int[] num, 
                        int target, 
                        List results, 
                        int startIndex, 
                        List list) {

        if (target == 0) {
            results.add(new ArrayList<>(list));
        }

        for (int i = startIndex; i < num.length; i++) {
            if (i > 0 && num[i] == num[i - 1] && i > startIndex) {
                continue;
            }   // 去重  
            if (target < num[i]) {
                break;
            }
            
            list.add(num[i]);
            helper(num, target - num[i], results, i + 1, list);
            list.remove(list.size() - 1);
        }
        
    }
}