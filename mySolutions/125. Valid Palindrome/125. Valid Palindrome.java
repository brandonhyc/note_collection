class Solution {
    public boolean isPalindrome(String s) {
        
        if (s == null || s.length() == 0) {
            return true;
        }
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        int left = 0;
        int right = s.length() - 1;
        boolean result = true;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                result = false;
            }
            left++;
            right--;
        }
        
        return result;
    }
}