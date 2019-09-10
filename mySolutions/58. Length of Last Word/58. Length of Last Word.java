class Solution {
    public int lengthOfLastWord(String s) {
        
        int endIndex = s.length() - 1;
        int len = 0;
        
        while (endIndex >= 0 && s.charAt(endIndex) == ' ') {
            endIndex--;
        }
        
        while (endIndex >= 0 && s.charAt(endIndex) != ' ') {
            len++;
            endIndex--;
        }
        
        return len;
    }
}