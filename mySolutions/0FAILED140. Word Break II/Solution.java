public class Solution {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here
        List<String> results = new ArrayList<>();

        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return results;
        }

        helper(s, wordDict, results, 0, new ArrayList());
        return results;
    }
    private void helper(String s, 
                        Set<String> wordDict, 
                        List<String> results,
                        int startIndex, 
                        List<String> subStrings) {
        if (startIndex >= s.length()) {
            // exit
            // convert
            String result = String.join(" ", subStrings); 
            results.add(result);
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String subString = s.substring(startIndex, i + 1);
            if (wordDict.contains(subString)) {
                subStrings.add(subString);
                helper(s, wordDict, results, i + 1, subStrings);
                subStrings.remove(subStrings.size() - 1);
            }
        }
    }
}