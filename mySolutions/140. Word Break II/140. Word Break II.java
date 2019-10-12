class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        return backtrack(s, wordDict, new HashMap<>());
        
    }
    
    private List<String> backtrack(String s, List<String> wordDict, Map<String, List<String>> map) {
        // System.out.printf("s: %s, wordDict: %s, results: %s, sb: %s, start: %d\n", s, wordDict.toString(), results.toString(), sb.toString(), start);
        
        if (s.length() == 0) {
            // String str = sb.toString().substring(0, sb.length() - 1);
            List<String> result = new ArrayList<>();
            result.add("");
            return result;
        }
        
        if (map.containsKey(s)) {
            return map.get(s);
        }
        
        List<String> results = new ArrayList<>();
        
        for (String can: wordDict) {
            if (!s.startsWith(can)) {
                continue;
            }
            
            String substring = s.substring(can.length(), s.length());
           
            List<String> subResults = backtrack(substring, wordDict, map);

            for (String subResult: subResults) {
                subResult = (subResult.length() == 0 ) ? "" + can : can + " " + subResult;
                results.add(subResult);
            }
        }
        
        map.put(s, results);
        
        return results;
    }
}