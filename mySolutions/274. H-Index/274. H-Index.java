class Solution {
    // 排序，找出第一个citation数大的数。
    public int hIndex(int[] citations) {
        
        if (citations.length == 0) {
            return 0;
        }
        
        int maxIndex = citations.length;
        int[] counts = new int[citations.length + 1];
        
        for (int i = 0; i < citations.length; i++) {
            
            if (citations[i] >= maxIndex) {
                counts[maxIndex]++;
            } else {
                counts[citations[i]]++;
            }
            
        }
        // System.out.println(Arrays.toString(counts));
        
        int total = 0;
        for (int i = counts.length - 1; i >= 0; i--) {
            total += counts[i];
            
            if (total >= i) {
                return i;
            }
            
        }
        
        return 0;
        
    }
}