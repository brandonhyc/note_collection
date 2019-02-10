class Solution {
    public String longestPalindrome(String s) {
        String longest = "";
        for (int start = 0; start < s.length(); start++) {
            int end = s.length();
            while (start < end) {
                String substr = s.subString(start, end);
                if (isPalindrome(substr)) {
                    longest = longest.length() < substr.length() ?  substr : longest;
                    break;
                }
            }
        }
        return longest;
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