
import java.util.Arrays;

class MDSP {

    public int findMinimumInsertion(String st) {
        // subtracting the length of Longest Palindromic Subsequence from the length of
        // the input string to get minimum number of deletions
        if (st.length() == 0) {
            return 0;
        }
        Integer[][] dp = new Integer[st.length()][st.length()];
        return findLPSeq(st, 0, st.length() - 1, dp);
    }

    private int findLPSeq(String st, int start, int end, Integer[][] dp) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return 0;
        }

        if (dp[start][end] != null) {
            return dp[start][end];
        }

        int count1 = Integer.MAX_VALUE;
        int count2 = Integer.MAX_VALUE;
        int count3 = Integer.MAX_VALUE;

        if (st.charAt(start) == st.charAt(end)) {
            count1 = findLPSeq(st, start + 1, end - 1, dp);
        } else {
            count2 = 1 + findLPSeq(st, start + 1, end, dp);
            count3 = 1 + findLPSeq(st, start, end - 1, dp);
        }
        int maxCount = Math.min(count1, count2);
        dp[start][end] = Math.min(maxCount, count3);
        // System.out.printf("start: %d, end: %d, dp[start][end]: %d\n", start, end, dp[start][end]);
        return dp[start][end];
    }

    public static void main(String[] args) {
        MDSP mdsp = new MDSP();
        System.out.println(mdsp.findMinimumInsertion("abdbca"));
        System.out.println(mdsp.findMinimumInsertion("cddpd"));
        System.out.println(mdsp.findMinimumInsertion("pqr"));
    }
}