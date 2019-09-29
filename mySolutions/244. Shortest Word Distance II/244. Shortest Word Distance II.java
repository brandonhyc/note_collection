class WordDistance {

    Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        
        int i = 0;
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, new ArrayList<>());
            }
            
            map.get(word).add(i);
            i++;
        }
        
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> word1List = map.get(word1);
        List<Integer> word2List = map.get(word2);
        
        int ptr1 = 0;
        int ptr2 = 0;
        int diff = Integer.MAX_VALUE;
        
        while (ptr1 < word1List.size() && ptr2 < word2List.size()) {
            int index1 = word1List.get(ptr1);
            int index2 = word2List.get(ptr2);
            
            diff = Math.min(Math.abs(index1 - index2), diff);
            
            if (index1 < index2) {
                ptr1++;
            } else {
                ptr2++;
            }
        }
        
        return diff;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */