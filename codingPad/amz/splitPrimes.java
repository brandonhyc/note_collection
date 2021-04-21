package codingPad.amz;

public class splitPrimes {
    public static int splitPrimes(String inputStr) {
        return search(inputStr, 0, new Integer[inputStr.length()]);
    }

    private static int search(String inputStr, int start, Integer[] dp) { // how many ways to cut [start, n - 1]
        if (start == inputStr.length()) return 1;
        if (dp[start] != null) return dp[start];

        // cut a word [start, end]
        int wayCount = 0;
        if (inputStr.charAt(start) == '0') {
            wayCount = 0;
        } else {
            for (int i = start + 1; i <= inputStr.length(); i++) {
                if (i - start == inputStr.length()) continue;
                String numStr = inputStr.substring(start, i);
                int num = Integer.parseInt(numStr);
                if (isPrimeLower1000(num)) {
                    wayCount += search(inputStr, i, dp);
                }
            }
        }

        dp[start] = wayCount;
        return dp[start];
    }

    private static boolean isPrimeLower1000(int num) {
        if (num <= 1 || num > 1000) return false;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }


}
