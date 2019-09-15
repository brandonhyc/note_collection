class Solution {
    public boolean isOneEditDistance(String s, String t) {
        
        for (int i = 0; i < s.length() && i < t.length(); i ++) {
            
            if (s.charAt(i) != t.charAt(i)) {
                
                if (s.length() < t.length()) {
                    return s.substring(i, s.length()).equals(t.substring(i + 1, t.length()));
                }
                else if (s.length() > t.length()) {
                    return s.substring(i + 1, s.length()).equals(t.substring(i, t.length()));
                }
                else if (s.length() == t.length()) {
                    if (i + 1 >= s.length()) {
                        return true;
                    }
                    return s.substring(i + 1, s.length()).equals(t.substring(i + 1, t.length()));
                }
            }
            
        }

        return Math.abs(s.length() - t.length()) == 1;
    }
}