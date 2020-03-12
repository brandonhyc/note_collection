// lc 1239
//https://leetcode.com/discuss/interview-question/401826/
class Solution {
    
    int maxLen = 0;
    public int maxLength(List<String> words) {
        
        backtrack(words, new HashSet<>(), 0);
        
        return maxLen;
        
    }
    
    private void backtrack(List<String> words, Set<Character> uniques, int start) {
        if (start == words.size()) maxLen = Math.max(maxLen, uniques.size());
        
        for (int i = start; i < words.size(); i++) {
            char[] chs = words.get(i).toCharArray();
            boolean added = true;
            for (int j = 0; j < chs.length; j++) {
                if (uniques.add(chs[j])) continue;
                // else if existed, rollback
                for (int k = 0; k < j; k ++) uniques.remove(chs[k]);
                added = false;
                break;
            }
            backtrack(words, uniques, i + 1);
            if (added) {
                for (int j = 0; j < chs.length; j++) {
                    uniques.remove(chs[j]);
                }
            }
        }
    }
}