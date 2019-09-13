class Solution {
    public int hIndex(int[] citations) {
        
        if (citations.length == 0) {
            return 0;
        }
        
        int len = citations.length; 
        int left = 0, right = citations.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2; 
            if (citations[mid] >= len - mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        // System.out.printf("left: %d, right: %d, citations[left]: citations[left]: %d, citations[right]: %d, len: %d", left , right, citations[left], citations[right], len);
        
        if (citations[left] >= len - left) {
            return len - left;
        }
        
        return (citations[right] < 1) ? 0 : len - right;
    }
}