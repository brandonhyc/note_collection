class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        if len(s) == 0:
            return 0

        dp = [[0 for j in range(len(s))] for i in range(len(s))]

        for i in range(len(s)):
            dp[i][i] = 1

        for left in range(len(s) - 1, -1, -1):
            for right in range(left + 1, len(s)):
                
                if (s[left] == s[right]):
                    dp[left][right] = 2 + dp[left + 1][right - 1]
                else:
                    dp[left][right] = max(dp[left + 1][right], dp[left][right - 1])
        

        return dp[0][len(s) - 1]  