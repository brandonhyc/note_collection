package codingPad.amz;

public class maxScore {
    public int maxScore(int[] n) {
        return search(n, 1, 0, new Integer[n.length / 2 + 1][1 << n.length]);
    }

    public int search(int[] nums, int round, int currMask, Integer[][] memo) {

        if (round > nums.length / 2) {
            return 0;
        }
        if (memo[round][currMask] != null) {
            return memo[round][currMask];
        }

        int maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int nextMask = (1 << i) + (1 << j);
                if ((currMask & nextMask) == 0) {
                    int nextScore = search(nums, round + 1, currMask + nextMask, memo);
                    maxSum = Math.max(maxSum, round * gcd(nums[i], nums[j]) + nextScore);
                }
            }
        }

        memo[round][currMask] = maxSum;
        return maxSum;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
