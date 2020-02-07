class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        
        boolean firstChMatch = s.length() != 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        
        if (p.length() > 1 && p.charAt(1) == '*') {
            boolean skipStar = isMatch(s.substring(0), p.substring(2));
            boolean skipChar = firstChMatch && isMatch(s.substring(1), p.substring(0));
            return skipStar || skipChar;
        }
        
        return firstChMatch && isMatch(s.substring(1), p.substring(1));
        
    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        Integer[][] dp = new Integer[s.length() + 1][p.length() + 1]; // null: NOT VISITED / 1: found a match / 0: not a match
        return isMatch(s, p, 0, 0, dp);
    }

    public boolean isMatch(String s, String p, int si, int pi, Integer[][] dp) {
        if (p.length() == pi) {
            return s.length() == si;
        }

        if (dp[si][pi] != null) {
            return dp[si][pi] == 1;
        }

        boolean firstChMatch = s.length() != si && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.');

        if (pi + 1 <= p.length() - 1 && p.charAt(pi + 1) == '*') {
            boolean skipStar = isMatch(s, p, si, pi + 2, dp);
            boolean skipChar = firstChMatch && isMatch(s, p, si + 1, pi, dp);
            dp[si][pi] = (skipStar || skipChar) ? 1 : 0;
            return dp[si][pi] == 1;
        }
        dp[si][pi] = (firstChMatch && isMatch(s, p, si + 1, pi + 1, dp)) ? 1 : 0;

        return dp[si][pi] == 1;

    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = false;
        }

        for (int si = 0; si <= s.length(); si++) {
            for (int pi = 0; pi <= p.length(); pi++) {

            }
        }

        if (p.length() == 0) {
            return s.length() == 0;
        }

        boolean firstChMatch = s.length() != 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() > 1 && p.charAt(1) == '*') {
            boolean skipStar = isMatch(s.substring(0), p.substring(2));
            boolean skipChar = firstChMatch && isMatch(s.substring(1), p.substring(0));
            return skipStar || skipChar;
        }

        return dp[s.length()][p.length()];

    }
}