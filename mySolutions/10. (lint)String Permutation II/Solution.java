public class Solution {
    /**
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        // write your code here

        List<String> results = new ArrayList<>();

        if (str.length() == 0) {
            results.add("");
            return results;
        }

        char[] strArray = str.toCharArray();
        Arrays.sort(strArray);
        String sortedStr = new String(strArray); 

        dfs(sortedStr, results, "", new boolean[str.length()]);
        return results;
    }
    private void dfs(String str, List<String> results, 
                    String substring, boolean[] visited) {
        if (substring.length() == str.length()) {
            results.add(new String(substring));
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && str.charAt(i - 1) == str.charAt(i) &&
                !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            dfs(str, results, substring + str.charAt(i), visited);
            visited[i] = false;
        }
        return;
        // "aabb", "abab"
    }
}