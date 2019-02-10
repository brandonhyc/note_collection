class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];

        for (int end = 0; end <= n; end++) {
            for (int start = 0; start <= i; start++) {
                dp[j][i] = (j + 1 > i - 1 || dp[j+1][i-1]) 
                && s.charAt(j) == s.charAt(i);
                if ()
            }
        }
    }
}