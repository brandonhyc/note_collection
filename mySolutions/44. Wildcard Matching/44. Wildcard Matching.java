class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    public boolean isMatch(String s, String p, int si, int pi) {
        if (pi == p.length()) {
            return si == s.length();
        }

        if (p.charAt(pi) == '?' || p.charAt(pi) == s.charAt(si)) {
            return isMatch(s, p, si + 1, pi + 1);
        }

        if (p.charAt(pi) == '*') {
            boolean skipStar = isMatch(s, p, si + 1, pi);
            boolean skipLetter = isMatch(s, p, si, pi + 1);
            return skipStar || skipLetter;
        }

        return false;
    }
}