class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> unused = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        
        queue.offer(beginWord);
        int depth = 1;
        
        while (queue.size() != 0) {
            int size = queue.size();
            depth += 1;
            
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                // System.out.printf("curr: %s\n", curr);
                for (int j = 0; j < curr.length(); j++) {
                    char[] chars = curr.toCharArray();
                    for (int k = 0; k < 26; k++) {
                        chars[j] = (char)('a' + k);
                        String nw = String.valueOf(chars);
                        if (unused.contains(nw)) {
                            queue.offer(nw);
                            unused.remove(nw);
                            if (nw.equals(endWord)) {
                                return depth;
                            }
                        }
                    }
                }
            }
        }
        
        return 0;
    }
}