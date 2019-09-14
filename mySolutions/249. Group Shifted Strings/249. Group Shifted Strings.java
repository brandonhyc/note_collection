class Solution {
    public List<List<String>> groupStrings(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];

            String key = getKey(str);
            // System.out.printf("%s\n", key);
            List list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
    
        return new ArrayList<>(map.values());
    }

    private String getKey(String str) {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i < str.length(); i++) {
            int diff = str.charAt(i) - str.charAt(i - 1);
            diff = diff > 0 ? diff : 26 + diff;
            sb.append(diff);
        }
        return sb.toString();
    }
}