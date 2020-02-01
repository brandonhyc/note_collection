class Solution {
    public int longestOnes(int[] A, int K) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        
        int kCount = 0;
        
        for (; right < A.length; right++) {
            if (A[right] == 0) {
                kCount += 1;
                while (kCount > K && left <= right) { 
                    if (A[left] == 0) {
                        kCount -= 1;
                        left += 1;
                        break;
                    }
    
                    left += 1;                
                }
            }
            
            maxLen = Math.max(right - left + 1, maxLen);
        }
        
        
        return maxLen;
    }

}