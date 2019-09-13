class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charSArray = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charSArray[s.charAt(i) - 'a']++;
            charSArray[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < charSArray.length; i++) {
            if (charSArray[i] != 0) {
                return false;
            }
        }

        return true;
    }
}