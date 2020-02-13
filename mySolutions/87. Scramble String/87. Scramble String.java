class Solution {
    public boolean isScramble(String s1, String s2) {
        
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        
        int[] chars = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i) - 'a'] += 1;
            chars[s2.charAt(i) - 'a'] -= 1;
        }
        
        for (int i = 0; i < 26; i++) if (chars[i] != 0) return false;
    
        for (int i = 1; i < s1.length(); i++) {
            int len = s1.length();
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) return true;
            if (isScramble(s1.substring(0, i), s2.substring(len - i, len)) && isScramble(s1.substring(i, len), s2.substring(0, len - i))) return true;
            
            
        }
        return false;
    }
}