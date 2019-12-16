class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        Set<String> bannedSet = new HashSet<>();
        for (String str : banned) {
            bannedSet.add(str);
        }
        String[] words = paragraph.split("\\W+");
        Map<String, Integer> map = new HashMap<>();

        PriorityQueue<String> maxHeap = new PriorityQueue<>((n1, n2) -> map.get(n2) - map.get(n1));

        for (String word : words) {
            word = word.toLowerCase();

            if (!map.containsKey(word)) {
                map.put(word, 0);
            }
            map.put(word, map.get(word) + 1);
        }

        for (String key : map.keySet()) {
            maxHeap.add(key);
        }

        while (maxHeap.size() > 0) {
            String word = maxHeap.poll().toLowerCase();

            if (!bannedSet.contains(word)) {
                return word;
            }
        }

        return "None";
    }
}