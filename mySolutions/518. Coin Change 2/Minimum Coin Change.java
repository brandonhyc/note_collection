import java.util.Arrays;

class CoinChange {

  public int countChange(int[] denominations, int total) {
    if (denominations.length == 0) {
        return -1;
    }
    int[][] dp = new int[denominations.length][total + 1];

    for (int i = 0; i < denominations.length; i++) {
        
        for (int j = 0; j <= total; j++) {

            if (j == 0) {
              dp[i][j] = 0;
              continue;
            }

            int count1 = Integer.MAX_VALUE;
            int count2 = Integer.MAX_VALUE;

            if (j - denominations[i] >= 0) {
                if (dp[i][j - denominations[i]] != Integer.MAX_VALUE) {
                    count1 = 1 + dp[i][j - denominations[i]];
                }
            }
            if (i - 1 >= 0) {
                count2 = dp[i - 1][j];
            }

            dp[i][j] = Math.min(count1, count2);
        }
    }
System.out.println(Arrays.deepToString(dp));

    return dp[denominations.length - 1][total];
    
  }

  public static void main(String[] args) {
    CoinChange cc = new CoinChange();
    int[] denominations = {1, 2, 3};
    System.out.println(cc.countChange(denominations, 5));
    System.out.println(cc.countChange(denominations, 11));
    System.out.println(cc.countChange(denominations, 7));
    denominations = new int[]{3, 5};
    System.out.println(cc.countChange(denominations, 7));
  }
}