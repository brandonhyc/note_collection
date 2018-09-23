public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        // write your code here

        List<List<Integer>> results = new ArrayList<>();
        if (n == 0 || k == 0) {
            results.add(new ArrayList<>());
            return results;
        }

        helper(n, k, 1, new ArrayList<Integer>());
        return results;
    }
    private void helper(int n, 
                    int k, 
                    int startIndex,
                    List comb) {
        
        if (k == 0) {
            results.add(comb);
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            comb.add(i);
            helper(n, k - 1, i + 1, comb);
            comb.remove(comb.size() - 1);
        }
    }
}