class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i >= 0; i++) {
            for (int j = 0; j <= i; j++) {
                dp[j][i] = (j + 1 > i - 1 || dp[j+1][i-1]) 
                && s.charAt(j) == s.charAt(i);
                if ()
            }
        }
    }
}