class Solution {
    public List<String> generateAbbreviations(String word) {

        List<String> results = new ArrayList<String>();

        backtrack(word, results, "", 0, 0);

        return results;
    }

    private void backtrack(String word, List<String> results, String breviate, int start, int count) {

        if (word.length() == start) {
            results.add(new String(breviate + (count == 0 ? "" : count)));
            return;
        }

        // if keep old char
        backtrack(word, results, breviate + (count != 0 ? count : "") + word.charAt(start), start + 1, 0);
        // if not keeping old char
        backtrack(word, results, breviate, start + 1, count + 1);

    }
}