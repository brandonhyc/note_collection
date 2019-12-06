// https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/YQVZJx1k0WY

class CutRibbon {

  public int countRibbonPieces(int[] ribbonLengths, int total) {
    
    // for each type of length 'l'
        // 1. create a new subset include that 'l' if not excess, process the rest length recursively
        // 2. create a new subset do not include 'l', process the rest length recursively
    // return the subset from above two with a higher number of pieces 

    int[][] dp = new int[ribbonLengths.length][total + 1];
    for (int i = 0; i < ribbonLengths.length; i++) {

        for (int j = 0; j < total + 1; j++) {

            if (j == 0) {
                dp[i][j] = 0;
                continue;
            }
            // exit
            int count1 = -1;
            int count2 = -1;

            if (j - ribbonLengths[i] >= 0) {
              if (dp[i][j - ribbonLengths[i]] != -1) {
                count1 = 1 + dp[i][j - ribbonLengths[i]];
              }
            }
            if (i - 1 >= 0) {
                count2 = dp[i - 1][j];
            }

            dp[i][j] = Math.max(count1, count2);
        }
    }
    return dp[ribbonLengths.length - 1][total];
  }

  public static void main(String[] args) {
    CutRibbon cr = new CutRibbon();
    int[] ribbonLengths = {2,3,5};
    System.out.println(cr.countRibbonPieces(ribbonLengths, 5));
    ribbonLengths = new int[]{2,3};
    System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
    ribbonLengths = new int[]{3,5,7};
    System.out.println(cr.countRibbonPieces(ribbonLengths, 13));
    ribbonLengths = new int[]{3,5};
    System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
  }
}