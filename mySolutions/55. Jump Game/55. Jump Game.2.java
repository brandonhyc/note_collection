class Solution {
    public boolean canJump(int[] jumps) {
        if (jumps.length == 0) {
            return true;
        }

        int[] dp = new int[jumps.length];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }

            for (int j = 1; j <= jumps[i]; j++) {
                // pick the possible minimum move
                if (i + j <= jumps.length - 1) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
        }

        return dp[jumps.length - 1] != Integer.MAX_VALUE;
    }
}