class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];

        for (int end = 0; end <= n; end++) {
            for (int start = 0; start <= end; start++) {

                if (s.charAt(start) != s.charAt(end)) {
                    dp[start][end] = false;
                    continue;
                }
                // known: head = tail
                if (end - start + 1 < 3) {
                    dp[]
                } else if () {

                }

                dp[start][end] = (end - start + 1 < 3 || dp[start + 1][end - 1]) 
                && s.charAt(start) == s.charAt(end);
                if ()
            }
        }
    }
}