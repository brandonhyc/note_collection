class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [None for i in range(len(s) + 1)]
        start = 0

        return self.dfs(s, start, wordDict, dp)

    def dfs(self, s, start, wordDict, dp):
        # print(s[start:])
        if len(s) == start:
            return True

        if dp[start] != None:
            return dp[start]

        parsed = False
        for i in range(start + 1, len(s) + 1):
            word = s[start: i]

            if word in wordDict and self.dfs(s, i, wordDict, dp):
                parsed = True

        dp[start] = parsed
        return dp[start]