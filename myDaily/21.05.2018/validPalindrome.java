public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0 || s == null) {
            return true;
        }
    
        int first = 0, end = s.length() - 1;
        while (first < end) {
            while (first < s.length() && !isValid(s.charAt(first))) {
                first++;
            }

            if (first == s.length()) {
                return true;
            }
            
            while (end >= 0 && !isValid(s.charAt(end))) {
                end--;
            }
            
            if (Character.toLowerCase(s.charAt(first)) != Character.toLowerCase(s.charAt(end))) {
                break;
            } 
            
            first++;
            end--;
        }

    return end <= first;
    }

    public boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}