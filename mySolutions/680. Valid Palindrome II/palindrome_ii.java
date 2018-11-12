public class Solution {
    /**
     * @param s: a string
     * @return: nothing
     */
    public boolean validPalindrome(String s) {
        // Write your code here

        if (s == null || s.length() == 0) {
            return true;
        }

        boolean motified = false;
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (motified && s.charAt(left) != s.charAt(right)) {
                return false;
            }
            if (s.charAt(left) == s.charAt(right)) {
                left++; right--;
                continue;
            }
            if (!motified) {
                motified = true;
                if (left + 1 <= right && s.charAt(left + 1) == s.charAt(right)) {
                    left++;
                } else if (left <= right - 1 && s.charAt(left) == s.charAt(right - 1)) {
                    right--;
                } else {
                    return false;
                }
                left++; right--;
            }
        }

        return true;
    }
}