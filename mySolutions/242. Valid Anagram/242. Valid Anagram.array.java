class Solution {
    public boolean isAnagram(String s, String t) {

        int[] sMap = new int['z' - 'a' + 1];
        int[] tMap = new int['z' - 'a' + 1];

        for (int i = 0; i < s.length(); i++) {
            sMap[s.charAt(i) - 'a'] = sMap[s.charAt(i) - 'a'] + 1;
        }

        for (int i = 0; i < t.length(); i++) {
            tMap[t.charAt(i) - 'a'] = tMap[t.charAt(i) - 'a'] + 1;
        }

        return Arrays.equals(sMap, tMap);
    }
}