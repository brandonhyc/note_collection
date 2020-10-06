public class Solution {
  public int numIncreasingSubsequences(int[] a) {

    if (a == null || a.length == 0) {
      return 0;
    }
    
    int total = 1;
    int[] M = new int[a.length];
    M[0] = 1;
    
    for (int i = 1; i < a.length; i++) {
      M[i] = 1;
      for (int j = i - 1; j >= 0; j--) {
        if (a[j] < a[i]) {
          M[i] += M[j];
        }
      }
      total += M[i];
    }

    return total;
  }
}