public class Solution {
    /**
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        // write your code here

        List<String> results = new ArrayList<>();

        if (str.length == 0) {
            return results;
        }

        char[] strArray = str.toCharArray();
        Arrays.sort(strArray);
        String sortedStr = new String(strArray); 

        dfs(sortedStr, results, "", 0, new boolean[str.length()]);
        return results;
    }
    private void dfs(String str, List<String> results, 
                    String substring, int startIndex, boolean[] visited) {
        if (startIndex == str.length) {
            results.add(new String(substring));
            return;
        }

        if (visited[startIndex]) {
            return;
        }

        for (char c : str.toCharArray()) {
            if (startIndex > 0 && 
                str.charAt(startIndex) == str.charAt(startIndex - 1) &&
                !visited[startIndex - 1]) {
                continue;
            }

            dfs(str, results, substring + c, startIndex + 1, visited);
        }
        return;
        // "aabb", "abab"

        
    }
}