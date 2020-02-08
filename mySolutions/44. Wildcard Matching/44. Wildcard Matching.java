class Solution {
    public boolean isMatch(String s, String p) {
        
        Integer[][] dp = new Integer[s.length() + 1][p.length() + 1];
        return isMatch(s, p, 0, 0, dp);
    }
    private boolean isMatch(String s, String p, int si, int pi, Integer[][] dp) {
        
        if (pi == p.length()) {
            return si == s.length();
        }
        if (dp[si][pi] != null) {
            return dp[si][pi] == 1;
        }
        
        boolean firstMatch = si <= s.length() - 1 && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?');
        if (firstMatch) {
            dp[si][pi] = isMatch(s, p, si + 1, pi + 1, dp) ? 1 : 0;
        }
        
        else if (p.charAt(pi) == '*') {
            boolean skipStar = isMatch(s, p, si, pi + 1, dp);
            boolean skipChar = si <= s.length() - 1 && isMatch(s, p, si + 1, pi, dp);
            dp[si][pi] = skipStar || skipChar ? 1 : 0; 
        }
        else {
            dp[si][pi] = 0;
        }
        
        
        return dp[si][pi] == 1;
        
    }

}