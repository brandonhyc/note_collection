public class Solution {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        // write your code here

        List<List<String>> result = new ArrayList<>();
        List<String> local = new ArrayList<>();

        if (s.length() == 0) {
            result.add(local);
            return result; 
        }

        dfs(s, 0, result, new ArrayList<String>());

        return result;
    }

    private void dfs(String s, int index,
                     List<List<String>> result, 
                     List<String> snippets) {
        
        if (index >= s.length()) {
            result.add(new ArrayList<>(snippets));
            return;
        }

        if (index + 1 <= s.length()) {
            snippets.add(s.substring(index, index + 1));
            dfs(s, index + 1, result, snippets);
            snippets.remove(snippets.size() - 1);
        }

        if (index + 2 <= s.length()) {
            snippets.add(s.substring(index, index + 2));
            dfs(s, index + 2, result, snippets);
            snippets.remove(snippets.size() - 1);
        }
        return;
    }
    
}