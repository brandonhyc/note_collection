class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }

        boolean firstChMatch = s.length() != 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() > 1 && p.charAt(1) == '*') {
            boolean skipStar = isMatch(s.substring(0), p.substring(2));
            boolean skipChar = firstChMatch && isMatch(s.substring(1), p.substring(0));
            return skipStar || skipChar;
        }

        return firstChMatch && isMatch(s.substring(1), p.substring(1));

    }
}