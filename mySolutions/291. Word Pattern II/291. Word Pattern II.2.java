class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
            
        return bt(pattern, str, new HashMap<>(), new HashSet<>());
    }
    
    private boolean bt(String pattern, String str, Map<Character, String> charToWord, Set<String> existWords) {
        // System.out.printf("pattern: %s, str: %s\n", pattern, str);
        if (pattern.length() == 0) {
            return str.length() == 0;
        }
        if (str.length() == 0) {
            return false;
        }
        
        char ch = pattern.charAt(0); // a b a
        if (charToWord.containsKey(ch)) {
            String word = charToWord.get(ch);
            if (str.startsWith(word)) {
                return bt(pattern.substring(1), str.substring(word.length()), charToWord, existWords);
            } else {
                return false;
            }
        }
        boolean found = false;
        for (int i = 1; i <= str.length(); i++) {
            String word = str.substring(0, i); // r, e
            if (existWords.contains(word)) {
                continue;
            }
            charToWord.put(ch, word);
            existWords.add(word);
            found = bt(pattern.substring(1), str.substring(word.length()), charToWord, existWords) || found;
            charToWord.remove(ch);
            existWords.remove(word);
        }
        
        return found;
    }
}

// abab redblueredblue
// bab edblueredblue, map={a: r}
// ab dblueredblue, map={a: r, b: e} -> false
// bab edblueredblue, map={a: r}
// ...
// ab redblue, map={a: r, b: edblue} -> good
// b edblue, map={a: r, b: edblue} -> good
    
    
    
    