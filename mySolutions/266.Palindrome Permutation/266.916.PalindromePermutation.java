public class Solution {
    /**
     * @param s: the given string
     * @return: if a permutation of the string could form a palindrome
     */
    public boolean canPermutePalindrome(String s) {
        // write your code here

        // count appearance of time of each char
        // for loop to check how many odds
        // return false if odds are more than 1

        int[] counts = new int[26];
        char[] chars = s.toCharArray();
        int odd = 0;

        for (int i = 0; i < chars.length; i++) {
            counts[chars[i] - 'a']++;
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] % 2 == 1) {
                odd++;
            }
            if (odd >= 2) {
                return false;
            }
        }
        return true;
    }
}