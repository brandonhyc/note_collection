class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];

        for (int end = 0; end <= n; end++) {
            for (int start = 0; start <= end; start++) {
                dp[start][end] = (end - start < 2 || dp[start + 1][end - 1]) 
                && s.charAt(start) == s.charAt(end);
                if ()
            }
        }
    }
}