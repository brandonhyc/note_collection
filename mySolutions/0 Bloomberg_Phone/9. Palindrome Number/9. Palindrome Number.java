class Solution {
    public boolean isPalindrome(int x) {
        String str = x + "";
        if (str == null || str.length() == 0) {
            return false;
        }

        int left = 0;
        int right = str.length() - 1;

        boolean result = true;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                result = false;
            }
            left++;
            right--;
        }

        return result;
    }
}