class Solution {
    public int longestPalindromeSubseq(String s) {
        // for each char from beginning and ending
        //  1. create new seq, include current char if it's palindrome, recursively process the rest 
        //  2. create new seq, not include the current char
        Integer[][] dp = new Integer[s.length()][s.length()];
        return getLenRec(s, 0, s.length() - 1, dp);
    }

    private int getLenRec(String s, int left, int right, Integer[][] dp) {
        
        if (left > right) {
            return 0;
        }

        
        if (dp[left][right] != null) {
            return dp[left][right];
        }
        
        if (left == right) {
            dp[left][right] = 1;
            return dp[left][right];
        }

        int len = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        if (s.charAt(left) == s.charAt(right)) {
            count1 = 2 + getLenRec(s, left + 1, right - 1, dp);
        } else {
            count2 = getLenRec(s, left + 1, right, dp);
            count3 = getLenRec(s, left, right - 1, dp);
        }

        dp[left][right] = Math.max(count1, count2);
        dp[left][right] = Math.max(count3, dp[left][right]);

        return dp[left][right];
    }

}