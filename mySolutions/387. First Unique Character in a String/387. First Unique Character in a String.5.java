class Solution {
    public int firstUniqChar(String s) {
        Set<Character> dupls = new HashSet<>();
        Map<Character, Integer> uqs = new LinkedHashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (dupls.contains(ch)) continue;
            if (uqs.containsKey(ch)) {
                uqs.remove(ch);
                dupls.add(ch);
                continue;
            }
            uqs.put(ch, i);
        }
        if (uqs.size() == 0) return -1;
        
        return uqs.entrySet().iterator().next().getValue();
    }
}