class Solution {
    public String minWindow(String s, String t) {
        
        int[] misChar = new int[128];
        for (int i = 0; i < t.length(); i++) misChar[t.charAt(i) - 'A'] += 1;
        
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        
        int start = 0;
        int end = 0;
        int misCount = t.length();
        
        for (;end < s.length(); end += 1) {
            char ch = s.charAt(end);
            if (misChar[ch - 'A'] > 0) misCount -= 1;
            misChar[ch - 'A'] -= 1;
            
            // found a valid window
            while (misCount == 0) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }
                
                char rCh = s.charAt(start);
                misChar[rCh - 'A'] += 1;
                if (misChar[rCh - 'A'] > 0) misCount += 1;
                start += 1;
            }
            
        }        
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}