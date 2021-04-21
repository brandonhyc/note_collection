package codingPad.amz;

import java.util.List;

public class minDifficulty {
    class Solution {
        public int minDifficulty(List<Integer> jobDifficulty, int d) {

            // at least one task a day
            // d days difficulty = sum(each day difficulty)
            // difficulty = max(difficulty of job a day)
            if (jobDifficulty.size() < d) {
                return -1;
            }

            // define a memo M[d][difficulties.length], M[i][j] means the min df to finish j jobs using i days
            // define a memo maxDiff[difficulties.length] means, maxDiff[i] means the max df in [0, i]

            return search(jobDifficulty, 0, d, new Integer[jobDifficulty.size()][d + 1]);
        }

        private int search(List<Integer> difficulties, int currIdx, int remainD, Integer[][] memo) { // return min df to finish task[currIndx : n - 1] in remainD
            if (difficulties.size() - currIdx < remainD || remainD == 0 || currIdx == difficulties.size()) {
                return remainD == 0 && currIdx == difficulties.size() ? 0 : -1;
            }
            if (memo[currIdx][remainD] != null) {
                return memo[currIdx][remainD];
            }

            int maxDf = 0;
            int minRes = Integer.MAX_VALUE;

            for (int i = currIdx + 1; i <= difficulties.size(); i++) {
                maxDf = Math.max(maxDf, difficulties.get(i - 1));

                int res = search(difficulties, i, remainD - 1, memo);
                if (res != -1) {
                    if (res + maxDf < minRes) {
                        minRes = res + maxDf;
                    }
                }
            }

            memo[currIdx][remainD] = minRes;

            return minRes;

        }
    }
}
