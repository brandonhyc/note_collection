class Solution {
    public List<Integer> findSubstring(String str, String[] words) {
        if (str.length() == 0 || words.length == 0) {
            return new ArrayList<>();
        }
        
        Map<String, Integer> originalWordsMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int wordsCount = words.length;
        int wordLength = wordsCount == 0 ? 0 : words[0].length();
        
        for (String word : words) {
            int count = originalWordsMap.getOrDefault(word, 0);
            originalWordsMap.put(word, count + 1);
        }
        
        for (int windowStart = 0, windowEnd = wordLength * wordsCount; 
             windowStart < str.length() && windowEnd <= str.length(); 
             windowStart++, windowEnd++) {
            
            String substring = str.substring(windowStart, windowEnd);
            if (matchWords(originalWordsMap, substring, wordLength, wordsCount)) {
                result.add(windowStart);
            }
        }
        
        return result;
    }
    
    private boolean matchWords(Map<String, Integer> originalWordsMap, String str, int wordLength, int wordsCount) {
        Map<String, Integer> map = new HashMap<>();
        // System.out.printf("%s, str: %s, wordLength: %d, wordsCount: %d\n", Arrays.toString(originalWordsMap.entrySet().toArray()), str, wordLength, wordsCount);
        for (int i = 0; i < wordsCount; i++) {
            int wordStart = i * wordLength;
            String word =  str.substring(wordStart, wordStart + wordLength);
            
            int newCount = map.getOrDefault(word, 0) + 1; 
            map.put(word, newCount);
            
            int oldCount = originalWordsMap.getOrDefault(word, 0);
            // System.out.printf("word: %s, newCount: %d, oldCount: %d\n", word, newCount, oldCount);
            if (newCount > oldCount) {
                return false;
            }
        }
        
        return true;
    }
}