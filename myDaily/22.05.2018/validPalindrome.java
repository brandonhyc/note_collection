public class Solution {
    public boolean isPalindrome(String s) {
        int first = 0, end = s.length() - 1;
        while (first < end) {

            while (first < s.length() && !isValid(s.charAt(first))) {
                first++;
            }

            if (first == s.length()) {
                break;
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
        return first >= end;  

    }

    boolean isValid(char c) {
        return Character.isDigit(c) || Character.isLetter(c);
    }

}