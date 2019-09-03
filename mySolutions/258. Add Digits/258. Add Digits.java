public class Solution {
    public boolean isIsomorphic(String s1, String s2) {
        boolean result = true;
        int[] counts = new int[512];

        for (int i = 0; i < s1.length(); i++) {

            if (counts[s1.charAt(i)] != counts[s2.charAt(i) + 256]) {
                result = false;
                break;
            }
            counts[s1.charAt(i)] = i + 1;
            counts[s2.charAt(i) + 256] = i + 1;
        }

        return result;
    }
}