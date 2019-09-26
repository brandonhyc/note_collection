
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int count = 0;

        Deque<String> deque = new ArrayDeque<>();
        deque.offer(beginWord);

        while (!deque.isEmpty()) {
            int size = deque.size();
            count++;

            for (int i = 0; i < size; i++) {
                String curWord = deque.poll();

                if (curWord.equals(endWord)) {
                    return count;
                }

                List<String> cands = getNextWordList(curWord, wordList);
                for (String nextWord : cands) {
                    wordList.remove(nextWord);
                    deque.offer(nextWord);
                }
            }
        }

        return 0;
    }

    private List<String> getNextWordList(String word, List<String> wordList) {
        List<String> resultList = new ArrayList<>();
        for (String cand : wordList) {

            int differenceCount = 0;
            for (int i = 0; i < word.length(); i++) {
                if (cand.charAt(i) != word.charAt(i)) {
                    differenceCount++;
                }
            }
            if (differenceCount <= 1) {
                resultList.add(cand);
            }
        }
        return resultList;
    }
}