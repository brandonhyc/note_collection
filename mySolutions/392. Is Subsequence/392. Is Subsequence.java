class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int j = -1;
        int next = 0;
        for (int i = 0; i < s.length(); i++) {
            next = t.indexOf(s.charAt(i), j);
            // System.out.printf("j: %d, i: %d, next: %d\n", j, i, next);
            if (next == -1) {
                return false;
            }
            j = next + 1;
        }

        return next != -1;
    }
}