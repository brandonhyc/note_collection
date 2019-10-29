class Solution {
    public int characterReplacement(String s, int k) {
        
        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        int maxRepCount = 0;
        
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char nextChar = s.charAt(windowEnd);
            if (!map.containsKey(nextChar)) {
                map.put(nextChar, 0);
            }
            map.put(nextChar, map.get(nextChar) + 1);
            maxRepCount = Math.max(map.get(nextChar), maxRepCount);
            
            while (windowEnd - windowStart + 1 - maxRepCount> k) {
                char lastChar = s.charAt(windowStart);
                map.put(lastChar, map.get(lastChar) - 1);
                windowStart += 1;
            }
            
            maxLength = Math.max(windowEnd - windowStart + 1, maxLength);
        }
        
        return maxLength;
    }
}