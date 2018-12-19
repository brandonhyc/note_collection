public class Solution {
    /*
     * @param s: a string
     * @param dict: a set of n substrings
     * @return: the minimum length
     */
    public int minLength(String s, Set<String> dict) {
        // write your code here

        if (s == null || s.length() == 0) {
            return 0;
        }
        if (dict == null || dict.size() == 0) {
            return s.length();
        }

        int min = s.length();
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();

        queue.offer(s);
        while (!queue.isEmpty()) {
            
            String str = queue.poll();
            if (set.contains(str)) {
                continue;
            }
            set.add(str);
            min = Math.min(min, str.length());

            for (String word: dict) {
                int foundAt = str.indexOf(word);
                
                while (foundAt != -1) {
                    int length = word.length();
                    String substring = str.substring(0, foundAt) + 
                                        str.substring(foundAt + length, str.length());

                    if (!set.contains(substring)) {
                        queue.offer(substring);
                    }
                    if (foundAt <= str.length()) {
                        foundAt = str.indexOf(word, foundAt + 1);                    
                    } else foundAt = -1;
                }
            }
        }
        return min;
    }
}