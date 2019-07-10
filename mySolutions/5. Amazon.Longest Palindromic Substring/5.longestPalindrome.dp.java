class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String result = "";

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {

                if (s.charAt(i) == s.charAt(j) && i - j <= 1) {
                    dp[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j) && i - 1 >= 0 && j + 1 < n && dp[i - 1][j + 1]) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j] == true && (result.length() < i - j + 1)) {
                    result = s.substring(j, i + 1);
                }
            }
        }
        return result;
    }
}