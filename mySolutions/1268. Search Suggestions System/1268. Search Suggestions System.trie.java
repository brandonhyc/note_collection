class Solution {
    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        LinkedList<String> suggestions = new LinkedList<>();

        void insert(String word) {
            TrieNode root = this;
            for (char ch : word.toCharArray()) {
                if (root.child[ch - 'a'] == null) {
                    root.child[ch - 'a'] = new TrieNode();
                }

                root = root.child[ch - 'a'];
                root.suggestions.add(word);
                Collections.sort(root.suggestions);

                if (root.suggestions.size() > 3) {
                    root.suggestions.pollLast();
                }
            }
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        List<List<String>> results = new ArrayList<>();

        // build
        for (String prod : products) {
            root.insert(prod);
        }

        // search
        TrieNode trie = root;
        for (char ch : searchWord.toCharArray()) {
            List<String> suggestions = new ArrayList<>();

            if (trie != null) {
                trie = trie.child[ch - 'a'];
            }

            if (trie != null) {
                suggestions = trie.suggestions;
            }
            results.add(suggestions);
        }

        return results;
    }
}