class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = -1;
        
        for (int i = 0; i < s.length(); i++) {
            
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            }
            else if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), s.charAt(i) + 1);
            }
            
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                result = i;
                break;
            }
        }
        
        return result;
    }
}