
// https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/gkX4prBkRLj
// Minimum Deletions in a String to make it a Palindrome

class MDSP {

    public int findMinimumDeletions(String st) {
        // subtracting the length of Longest Palindromic Subsequence from the length of
        // the input string to get minimum number of deletions
        if (st.length() == 0) {
            return 0;
        }
        Integer[][] dp = new Integer[st.length()][st.length()];
        
        for (int i = 0; i < st.length(); i++) {
            dp[i][i] = 1;
        }

        for (int start = st.length() - 1; start >= 0; start--) {
            for (int end = start + 1; end <= st.length() - 1; end++) {
                int count1 = 0;
                int count2 = 0;
                int count3 = 0;
                
                if (st.charAt(start) == st.charAt(end)) {
                    if (start + 1 > end - 1) {
                        count1 = 2;
                    } else {
                        count1 = 2 + dp[start + 1][end - 1];
                    }
                } else {
                    count2 = dp[start + 1][end];
                    count3 = dp[start][end - 1];
                }

                dp[start][end] = Math.max(count1, count2);
                dp[start][end] = Math.max(count3, dp[start][end]);
            }
        }
        return st.length() - dp[0][st.length() - 1];

    }

    public static void main(String[] args) {
        MDSP mdsp = new MDSP();
        System.out.println(mdsp.findMinimumDeletions("abdbca"));
        System.out.println(mdsp.findMinimumDeletions("cddpd"));
        System.out.println(mdsp.findMinimumDeletions("pqr"));
    }
}





class MDSP {

    public int findMinimumDeletions(String st) {
        // subtracting the length of Longest Palindromic Subsequence from the length of
        // the input string to get minimum number of deletions
        if (st.length() == 0) {
            return 0;
        }
        Integer[][] dp = new Integer[st.length()][st.length()];
        return st.length() - findLPSeq(st, 0, st.length() - 1, dp);
    }

    private int findLPSeq(String st, int start, int end, Integer[][] dp) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return 1;
        }

        if (dp[start][end] != null) {
            return dp[start][end];
        }

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        if (st.charAt(start) == st.charAt(end)) {
            count1 = 2 + findLPSeq(st, start + 1, end - 1, dp);
        } else {
            count2 = findLPSeq(st, start + 1, end, dp);
            count3 = findLPSeq(st, start, end - 1, dp);
        }
        int maxCount = Math.max(count1, count2);
        dp[start][end] = Math.max(maxCount, count3);
        return dp[start][end];
    }

    public static void main(String[] args) {
        MDSP mdsp = new MDSP();
        System.out.println(mdsp.findMinimumDeletions("abdbca"));
        System.out.println(mdsp.findMinimumDeletions("cddpd"));
        System.out.println(mdsp.findMinimumDeletions("pqr"));
    }
}