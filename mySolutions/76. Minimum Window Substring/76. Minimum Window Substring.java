class Solution {
    public String minWindow(String str, String target) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (char ch : target.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 0);
            }
            map.put(ch, map.get(ch) + 1);
        }
        
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int minEnd = 0;
        int windowStart = 0;
        int windowEnd = 0;
        
        while (windowEnd < str.length()) {
            char ch = str.charAt(windowEnd);
            
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                
                while (matchTarget(map)) {
                    if (minLen > windowEnd - windowStart + 1) {
                        minLen = windowEnd - windowStart + 1;
                        minStart = windowStart;
                        minEnd = windowEnd;
                    }
                    
                    char preCh = str.charAt(windowStart);
                    if (map.containsKey(preCh)) {
                        map.put(preCh, map.get(preCh) + 1);
                    }
                    
                    windowStart += 1;
                }
                
            }
            
            windowEnd += 1;
            
        }
        return minLen == Integer.MAX_VALUE ? "" : str.substring(minStart, minEnd + 1);
    }
    
    private boolean matchTarget(Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> en : map.entrySet()) {
            if (en.getValue() > 0) {
                return false;
            }
        }
        return true;
    }
}