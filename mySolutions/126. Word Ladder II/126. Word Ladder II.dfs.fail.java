class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        List<List<String>> results = new ArrayList<>();
        List<String> sequence = new ArrayList<>();
        sequence.add(beginWord);
        
        backtrack(results, endWord, wordList, sequence);
        return results;
    }
    
    private void backtrack(List<List<String>> results, String endWord, List<String> wordList, List<String> sequence) {
        System.out.printf("endWord: %s, wordList: %s, sequence: %s\n", endWord, wordList.toString(), sequence.toString());
        if (!results.isEmpty() && results.get(0).size() < sequence.size()) {
            // System.out.println("drop");
            return;
        }
        
        if (sequence.get(sequence.size() - 1).equals(endWord)) {
            // System.out.println("found target");
            if (!results.isEmpty() && results.get(0).size() > sequence.size()) {
                results.clear();
                // System.out.println("clear");
            }
            List<String> res = new ArrayList<>();
            res.addAll(sequence);
            results.add(res);
            return;
        }
        
        String prev = sequence.get(sequence.size() - 1);
        List<String> candList = getNextWords(prev, wordList);
        
        for (int i = 0; i < candList.size(); i++) {   
            String cand = candList.get(i);
            sequence.add(cand);
            wordList.remove(cand);
            backtrack(results, endWord, wordList, sequence);
            wordList.add(cand);
            sequence.remove(sequence.size() - 1);
        }
    }
    
    private List<String> getNextWords(String prev, List<String> candList) {
        List<String> result = new ArrayList<>();
        
        for (String cand : candList) {
            int count = 0;
            for (int i = 0; i < prev.length(); i++) {
                if (prev.charAt(i) != cand.charAt(i)) {
                    count++;
                }
            }
            if (count < 2) {
                result.add(cand);
            }
        }
        
        return result;
    }
}
