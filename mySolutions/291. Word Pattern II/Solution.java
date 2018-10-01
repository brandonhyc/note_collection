public class Solution {
    /**
     * @param pattern: a string,denote pattern string
     * @param str: a string, denote matching string
     * @return: a boolean
     */
    public boolean wordPatternMatch(String pattern, String str) {
        // write your code here

        if (pattern.length() == 0 || str.length() == 0) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();

        return match(pattern, str, map);

    }

    private boolean match(String pattern, String str, Map<Character, String> map) {
        
        if (pattern.length() == 0) {
            return str.length() == 0;
        }
        char patternIndex = pattern.charAt(0);
        String word;
        if (map.containsKey(patternIndex)) {
            word = map.get(patternIndex);
            // if contains
            if (!str.startsWith(word)) {   
                return false;
            }
            return match(pattern.substring(1), str.substring(word.length()), map);
        }

        // else: do not contains
        for (int i = 0; i < str.length(); i++) {
            word = str.substring(0, i + 1);
            if (map.containsValue(word)) {
                continue;
            }
            map.put(pattern.charAt(0), word);
            if (match(pattern.substring(1), str.substring(word.length()), map)) {
                return true;
            }
            map.remove(pattern.charAt(0));
        }

        return false;

    }
    
}