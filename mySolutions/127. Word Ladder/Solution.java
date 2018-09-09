public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here

        if (dict == null || dict.size() == 0) {
            return -1;
        }

        dict.add(start); 
        dict.add(end);

        Set<String> set = new HashSet<>();
        Queue<String> que = new LinkedList<>();
        int count = 0;

        que.offer(start);
        while (!que.isEmpty()) {
            count++;
            int size = que.size();
            System.out.printf("---size: %d ------\n", count);
            for (int i = 0; i < size; i++) {
                String head = que.poll();
                System.out.print(head + " ");

                if (!set.add(head)) {
                    continue;
                }
                if (head.equals(end)) {
                    return count;
                }
                List<String> wordList = getNextWordList(dict, head);

                System.out.printf("wordList: %s\n", wordList);

                for (String word : wordList) {
                    que.offer(word);
                }
            }
        }
        return -1;
    }

    private List<String> getNextWordList(Set<String> dict, String word) {
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            for (char r = 'a'; r <= 'z'; r++) {
                if (r == c) {
                    continue;
                }
                char[] temp = word.toCharArray();
                temp[i] = r;

                String nextWord = new String(temp);
                if (dict.contains(nextWord)) {
                    list.add(nextWord);
                }
            }
        }
        return list;
    }
}