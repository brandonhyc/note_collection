class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Integer[] dp = new Integer[s.length() + 1];
        return canParse(dp, set, s, 0, s.length());        
    }
    
    private boolean canParse(Integer[] dp, Set<String> set, String str, int i, int j) {
        if (i == j) return true;
        if (dp[i] != null) return dp[i] == 1;
        
        boolean found = false;
        for (String prefix : set) {
            if (!found && str.startsWith(prefix, i) && canParse(dp, set, str, i + prefix.length(), j)){
                found = true; 
            }
        }
        dp[i] = (found) ? 1 : 0;
                
        return found;
    }
}