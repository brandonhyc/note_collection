class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String vowels = "aeiouAEIOU";

        int left = 0, right = s.length() - 1;
        while (left < right) {
            char lc = s.charAt(left);
            char rc = s.charAt(right);
            if (vowels.indexOf(lc) != -1 && 
                vowels.indexOf(rc) != -1) {
                reverse(s, left, right);
                left++;
                right--;
            }
        }
    }
}