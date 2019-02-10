class Solution {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < len; i++) {
            
        }
    }

    private boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++; right--;
        }

        return true;
    }
}