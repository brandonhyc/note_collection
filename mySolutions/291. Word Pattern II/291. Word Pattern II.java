class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        
        if (pattern.length() == 0 && str.length() == 0) {
            return true;
        }
        
        if (pattern.length() == 0 || str.length() == 0) {
            return false;
        } 
        
        return isMatch(pattern, str, new HashMap<>(), new HashSet<>(), 0, 0);
    }
    
    
    private boolean isMatch(String pattern, String str, Map<Character, String> map, Set<String> set, int pi, int si) {
        // pattern pi pch, str si sch
        
        // System.out.printf("pattern: %s, str: %s, map: %s, set: %s, pi: %d, si: %d\n", pattern, str, Arrays.toString(map.entrySet().toArray()), set.toString(), pi, si);
        
        // to both end, good
        if (pi == pattern.length() && si == str.length()) {
            return true;
        }
        if (pi == pattern.length() || si == str.length()) {
            return false;
        }
        
        // for each pch try to find it in map
        // start from previous point
        boolean result = false;
        char pch = pattern.charAt(pi);
        
        if (map.containsKey(pch)) {
            // if is a old pattern
            String knownStr = map.get(pch);
            if (!str.startsWith(knownStr, si)) {
                return false;
            }
            // if it old pattern match, check the rest subsetring from pi + 1, si + knwoStr.length()
            result = result || isMatch(pattern, str, map, set, pi + 1, si + knownStr.length());
        } 
        else {
            // if it's a new pattern
            for (int j = si + 1; j <= str.length(); j++) {
                String newStr = str.substring(si, j);
                if (set.contains(newStr)) {
                    continue;
                }
                set.add(newStr);
                map.put(pch, newStr);
                // pi + 1, si + newStr.length()
                result = result || isMatch(pattern, str, map, set, pi + 1, si + newStr.length());
                map.remove(pch);
                set.remove(newStr);

            }

        }
        
        return result;
        
        
    }
}