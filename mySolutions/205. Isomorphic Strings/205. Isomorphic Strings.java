class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sArray = new int[256];
        int[] tArray = new int[256];
        
        for (int i = 0; i < s.length(); i++) {
            int sIndex = s.charAt(i);
            int tIndex = t.charAt(i);
            
            if (sArray[sIndex] != tArray[tIndex]) {
                return false;
            }
            sArray[sIndex] = i + 1;
            tArray[tIndex] = i + 1;
        }
        
        return true;
    }
}