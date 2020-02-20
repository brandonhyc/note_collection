class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        return dfs(s, wordDict, new HashMap<>());
    }
    
    private List<String> dfs(String word, List<String> wordDict, Map<String, List<String>> map) {
        
        if (word.length() == 0) {
            List<String> result = new ArrayList<>();
            result.add("");
            return result;
        }
        
        if (map.containsKey(word)) {
            return map.get(word);
        }
        
        List<String> res = new ArrayList<>();
        for (String pre : wordDict) {
            if (word.startsWith(pre)) {
                List<String> sufWords = dfs(word.substring(pre.length()), wordDict, map);
                
                for (String suf : sufWords) {
                    String comb = pre + " " + suf;
                    res.add(comb.trim());
                }
            }
            
        }
        map.put(word, res);
        return res;
    }
}