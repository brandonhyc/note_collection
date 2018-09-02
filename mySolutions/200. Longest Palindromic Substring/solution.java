public class Solution {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {

        int maxLen = 0;
        int start = 0;
        if (s == null || s == "")
            return "";
        if (s.length() == 1)
            return s;
        /**
         * Read i in s, create a window within i, for-repeat expand the window, if the
         * windows is larger,
         */

        for (int i = 0; i < s.length() - 1; i++) {
            int len = getLen(s, i, i);
            if (maxLen < len) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }

            len = getLen(s, i, i + 1);
            if (maxLen < len) {
                maxLen = len;
                start = i - len / 2 + 1;
            }
        }
        System.out.printf("start: %d, maxLen: %d", start, maxLen);
        return s.substring(start, start + maxLen);
    }

    private int getLen(String s, int left, int right) {
        /**
         * Function checkLen: Two situations,
         */

        while (left >= 0 && right <= s.length() - 1) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            } else {
                left--;
                right++;
                len = len + 2;
            }
        }
        return right - left - 1;
    }
}