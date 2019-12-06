class Solution {
    public int fib(int N) {
        Integer[] dp = new Integer[N + 1];
        
        for (int i = 0; i <= N; i++) {
            if (i <= 1) {
                dp[i] = i;
                continue;
            }
            dp[i] = dp[i - 1] + dp[i - 2];    
        }

        return dp[N];
    }
}

class Solution {
    public int fib(int N) {
        Integer[] dp = new Integer[N + 1];
        return dfs(N, dp);
    }

    private int dfs(int n, Integer[] dp) {
        if (n <= 1) {
            return n;
        }
        
        if (dp[n] != null) {
            return dp[n];
        }
        
        int sum1 = dfs(n - 1, dp);
        int sum2 = dfs(n - 2, dp);
        dp[n] = sum1 + sum2;
        
        return dp[n];
    }
}