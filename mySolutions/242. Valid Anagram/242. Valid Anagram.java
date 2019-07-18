class Solution {
    public boolean isAnagram(String s, String t) {
        if  (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        
        Map<Integer, Integer> mapS = new HashMap<>();
        Map<Integer, Integer> mapT = new HashMap<>();
        
        putInMap(mapS, s);
        putInMap(mapT, t);
        
        return mapS.equals(mapT);
    }
    
    private void putInMap(Map<Integer, Integer> map, String s) {
        for (int i = 0; i < s.length(); i++) {
            Integer value = map.get(s.charAt(i) - 'a');
            
            if (value == null) {
                map.put(s.charAt(i) - 'a', 0);
                value = 0;
            }
            
            map.put(s.charAt(i) - 'a', value + 1);
        }
    }
}