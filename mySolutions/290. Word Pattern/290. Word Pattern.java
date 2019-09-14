class Solution {
    public boolean wordPattern(String pattern, String str) {

        Map<Character, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        String[] words = str.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char ch1 = pattern.charAt(i);
            String word = words[i];

            if (!map1.containsKey(ch1) && !map2.containsKey(word)) {
                map1.put(ch1, i);
                map2.put(word, i);
                continue;
            } else if (map1.containsKey(ch1) && map2.containsKey(word) && map1.get(ch1).equals(map2.get(word))) {
                map1.put(ch1, i);
                map2.put(word, i);
                continue;
            }
            // System.out.printf(" map1.get(ch1) == map2.get(word): %b\n",
            // map1.containsKey(ch1) && map2.containsKey(word) && map1.get(ch1) ==
            // map2.get(word));
            // System.out.printf("ch1: %c, map1.get(ch1): %d, map2.get(word): %d,
            // word:%s\n", ch1, map1.get(ch1), map2.get(word), word);
            return false;
        }

        return true;
    }
}