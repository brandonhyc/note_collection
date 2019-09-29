class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        
        int index1 = -1;
        int index2 = -1;
        int diff = Integer.MAX_VALUE;
        
        int count = 0;
        
        for (int i = 0; i < words.length; i++) {
            
            if (!word1.equals(word2)) {
                if (words[i].equals(word1)) {
                    index1 = i;
                }
                if (words[i].equals(word2)) {
                    index2 = i;
                }
            }
            else {
                if (words[i].equals(word1) && count % 2 == 1) {
                    index1 = i;
                    count++;
                } else if (words[i].equals(word1) && count % 2 == 0) {
                    index2 = i;
                    count++;
                }
                
            }
            // System.out.printf("index1: %d, index2: %d\n", index1, index2);
            if (index1 == -1 || index2 == -1) {
                continue;
            }
            diff = Math.min(Math.abs(index1 - index2), diff);    
            
        }
        
        return diff;
    }
}