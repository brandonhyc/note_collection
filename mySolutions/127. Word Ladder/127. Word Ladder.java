class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0) {
            return 0;
        }

        Set<String> set = new HashSet<String>();

        for (String str : wordList) {
            set.add(str);
        }

        int count = 0;

        set.remove(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {

                String word = queue.poll();

                if (word.equals(endWord)) {

                    return count;
                }

                List<String> candidateWords = getCandidataWords(word, set);
                for (String nextWord : candidateWords) {
                    set.remove(nextWord);
                    queue.offer(nextWord);
                }
            }

        }

        return 0;
    }

    private List<String> getCandidataWords(String startWord, Set<String> set) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < startWord.length(); i++) {
            char[] chars = startWord.toCharArray();
            for (int j = 0; j < 'z' - 'a'; j++) {
                chars[i] = (char) (j + 'a');
                String newWord = String.valueOf(chars);
                if (set.contains(newWord)) {
                    result.add(newWord);
                }
            }
        }

        return result;
    }

}