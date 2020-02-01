class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if (s1.length() > s2.length()) {
            return false;
        }
        
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }
        
        int left = 0;
        int right = 0;
        int count = targetMap.keySet().size();
        
        for (; right < s2.length(); right++) {
            char ch = s2.charAt(right);
            
            if (targetMap.containsKey(ch)) {
                int chCount = targetMap.get(ch) - 1;
                targetMap.put(ch, chCount);
                
                if (chCount == 0) {
                    count -= 1;
                }
            }
            
            while (count == 0) {
                if (right - left + 1 == s1.length()) {
                    return true;
                }
                char ch2 = s2.charAt(left); 
                // System.out.printf("left: %d, right: %d, ch2: %c, count: %d\n", left, right, ch2, count);
                // System.out.printf("%s\n", Arrays.toString(targetMap.entrySet().toArray()));

                if (targetMap.containsKey(ch2)) {
                    int chCount = targetMap.get(ch2) + 1;
                    targetMap.put(ch2, chCount);
                    
                    if (chCount == 1) {
                        count += 1;
                    }
                }
                left += 1;
            }
        }
        
        return false;
    }
}