public class Solution {
    /**
     * @param n: n
     * @param k: the k th permutation
     * @return: return the k-th permutation
     */
    public String getPermutation(int n, int k) {
        // write your code here

        if (n == 0 || k == 0) {
            return null;
        }

        String[] strs = new String[n];

        for (int i = 0; i < n; i++) {
            strs[i] = Integer.toString(i + 1);
        }

        List<String> results = new ArrayList<>();
        boolean[] visited = new boolean[n];
        StringBuffer s = new StringBuffer();
        dfs(strs, results, k, s, visited, 0);

        return results.get(k - 1);
    }

    private void dfs(String[] strs, 
                    List<String> results, 
                    int target,
                    StringBuffer combination, 
                    boolean[] visited,
                    int index) {
        
        if (index >= target) {
            return;
        }

        if (strs.length == combination.length()) {
            results.add(combination.toString());
            index++;
            return;
        }

        for (int i = 0; i < strs.length; i++) {
            if (visited[i]) {
                continue;
            }

            combination.append(strs[i]);
            visited[i] = true;

            dfs(strs, results, target, combination, visited, index);

            visited[i] = false;
            int size = combination.length();
            combination.deleteCharAt(size - 1);
        }
    }
}