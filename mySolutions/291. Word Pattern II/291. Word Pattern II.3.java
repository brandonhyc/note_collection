
class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        return canForm(pattern, s, 0, 0, new HashMap<>(), new HashSet<>());
    }

    private boolean canForm(String pattern, String s,
                            int i, int j,
                            Map<Character, String> map, Set<String> set) {
        if (i == pattern.length() && j == s.length()) return true;
        if (i >= pattern.length() || j >= s.length()) return false;

        char ch = pattern.charAt(i);
        String str = map.get(ch);
        if (str != null) {
            if (s.startsWith(str, j)) {
                return canForm(pattern, s, i + 1, j + str.length(), map, set);
            }
            return false;
        } else {
            for (int k = 1; j + k <= s.length(); k++) {
                String sub = s.substring(j, j + k);
                if (set.add(sub)) {
                    map.put(ch, sub);
                    boolean found = canForm(pattern, s, i + 1, j + k, map, set);
                    map.remove(ch);
                    set.remove(sub);

                    if (found) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}