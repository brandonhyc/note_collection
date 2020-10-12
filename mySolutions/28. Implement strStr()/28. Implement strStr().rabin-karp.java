class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;
        final int BASE = 128, PRIME = (int) Math.pow(10, 4) + 7;
        int N = haystack.length(), M = needle.length();
        int _haystack = 0, _needle = 0, POWER = 0;
        for (int i = 0; i < M; i++) {
            _haystack = (BASE * _haystack + haystack.charAt(i)) % PRIME;
            _needle = (BASE * _needle + needle.charAt(i)) % PRIME;
            POWER = POWER != 0 ? (POWER * BASE) % PRIME : 1;

        }

        if (_haystack == _needle && haystack.substring(0, M).equals(needle)) return 0;

        for (int i = M; i < N; i++) {
            _haystack = (BASE * (_haystack - POWER * haystack.charAt(i - M)) + haystack.charAt(i)) % PRIME;
            if (_haystack < 0) _haystack += PRIME;

            if (_haystack == _needle && haystack.substring(i + 1 - M, i + 1 ).equals(needle)) return i + 1 - M;
        }

        return -1;
    }
}