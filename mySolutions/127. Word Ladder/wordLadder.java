public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (start == null || end == null) {
            return -1;
        }
        if (dict == null) {
            return -1;
        }

        dict.add(end);

        int result = 0;
        Set<String> usedSet = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        usedSet.add(start);
        queue.offer(start);

        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String newWord = queue.poll();
                if (newWord.equals(end)) {
                    return result;
                }
                usedSet.add(newWord);
                List<String> candidateWords = getTailList(dict, newWord);
                
                for (String word : candidateWords) {
                    if (usedSet.contains(word)) {
                        continue;
                    }
                    queue.offer(word);
                }
            }
        } 
        return result;

    }

    private List<String> getTailList(
                        Set<String> dict, 
                        String word) {
        ArrayList<String> result = new ArrayList<>();

        for (int index = 0; index < word.length(); index++) {
            
            for (char letter = 'a'; letter <= 'z'; letter++) {
                if (letter == word.charAt(index)) {
                    continue;
                }
                char[] charArray = word.toCharArray();
                charArray[index] = letter;
                
                String newWord = new String(charArray);
                if (dict.contains(newWord)) {
                    result.add(newWord);
                }
            }
        }

        return result;
    }
}