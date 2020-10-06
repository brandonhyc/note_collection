public class Solution {
    public int[] kSmallest(int[] array, int k) {
      // check
      if (array == null || array.length == 0 || k == 0) {
        return new int[0];
      }
      qs(array, k, 0, array.length - 1);
  
      int[] res = Arrays.copyOf(array, k);
      Arrays.sort(res);
      return res;
    }
    private void qs(int[] array, int k, int start, int end) {
      
      int piv = findPivot(array, start, end);
      if (k - 1 == piv) {
        return;
      } else if (piv < k - 1) {
        qs(array, k, piv + 1, end);
      } else {
        qs(array, k, start, piv - 1);
      }
  
    }
  
    //   l        r
    //   0  1  2  3 
  
    private int findPivot(int[] array, int start, int end) {
      int piv = array[end];
      int left = start, right = end - 1; // [0, l) <= piv,  (r, n - 1] >= piv
  
      while (left <= right) {
        if (array[left] > piv) {
          swap(array, left, right);
          right--;
        } else if (array[left] <= piv) {
          left++;
        }
      }
      swap(array, left, end);
  
      return left;
    }
    private void swap(int[] array, int left, int right) {
      int temp  = array[left];
      array[left] = array[right];
      array[right]= temp;
    }
  }
  