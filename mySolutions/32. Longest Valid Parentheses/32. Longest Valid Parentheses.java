class Solution {
    public int longestValidParentheses(String s) {
        
        int[] dp = new int[s.length()];
        int maxLen = 0;
        char[] arr = s.toCharArray();
        for (int i = 1; i < s.length(); i++) {
            if (arr[i] == ')') {
                if (arr[i - 1] == '(') {
                    dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
                }
                else if (arr[i - 1] == ')' && i - dp[i - 1] - 1 >= 0 && arr[i - dp[i - 1] - 1] == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (i - dp[i - 1] - 2 >= 0) {
                        dp[i] += dp[i - dp[i - 1] - 2];
                    }
                }
                maxLen = Math.max(dp[i], maxLen);
            }
        }
        // System.out.printf("%s\n", Arrays.toString(dp));
        return maxLen;
    }
}