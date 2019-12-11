// https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/gxxqrE2kKrY
// Palindromic Partitioning

class MPP {

  public int findMPPCuts(String st) {
    // try all substring combination for each char
    // 1. include this char to existing substring if can be palindrome, recursively process the rest substring
    // 2. do not include this char if can't be palidrome, create new substring, recursively process the rest substring 
    
    Integer[][] dpIsPmd = new Integer[st.length()][st.length()];
    Integer[][] dpMPP = new Integer[st.length()][st.length()]; 

    return this.findMPPCutsRecursive(st, 0, st.length()-1, dpIsPmd, dpMPP);
  }

    private int findMPPCutsRecursive(String st, int startIndex, int endIndex, Integer[][] dpIsPmd, Integer[][] dpMPP) {
        if (startIndex >= endIndex) {
            return 0;
        }

        if (dpMPP[startIndex][endIndex] != null) {
            return dpMPP[startIndex][endIndex];
        }

        if (isPalindrome(st, startIndex, endIndex, dpIsPmd)) {
            return 0;
        }

        int count = 0;
        int minCutCount = endIndex - startIndex + 1;

        for (int end = endIndex; end >= startIndex; end -= 1) {
            if (isPalindrome(st, startIndex, end, dpIsPmd)) {
                minCutCount = Math.min(1 + findMPPCutsRecursive(st, end + 1, endIndex, dpIsPmd, dpMPP), minCutCount);
            }
        }

        return minCutCount;

    }

  private boolean isPalindrome(String st, int left, int right, Integer[][] dp) {
    if (left > right) {
        return false;
    }

    if (dp[left][right] != null) {
        return dp[left][right] == 1;
    }

    while (left < right) {
        
        if (st.charAt(left) != st.charAt(right)) {
            dp[left][right] = 0;
            return false;
        }

        left += 1;
        right -= 1;
    }
    dp[left][right] = 1;
    return true;
  }

  public static void main(String[] args) {
    MPP mpp = new MPP();
    System.out.println(mpp.findMPPCuts("abdbca"));
    System.out.println(mpp.findMPPCuts("cdpdd"));
    System.out.println(mpp.findMPPCuts("pqr"));
    System.out.println(mpp.findMPPCuts("pp"));
   }
}
