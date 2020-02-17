class Solution {
    public int romanToInt(String s) {
        
        Map<String, Integer> map = new HashMap() {{
            put("I", 1);
            put("IV", 4);
            put("V", 5);
            put("IX", 9);
            put("X", 10);
            put("XL", 40);
            put("L", 50);
            put("XC", 90);
            put("C", 100);
            put("CD", 400);
            put("D", 500);
            put("CM", 900);
            put("M", 1000);
        }};
        
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            String w = "";
            if (i + 1 <= s.length() - 1 && map.containsKey(s.substring(i, i + 2))) {
                w = s.substring(i, i + 2);
                i += 1;
            } else {
                w = s.substring(i, i + 1);
            }
            // System.out.printf("w: %s\n", w);
            total += map.get(w);
        }
        
        return total;
    }
}