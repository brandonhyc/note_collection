class WordDictionary {

    private class TrieNode {
        boolean isWord = false;
        TrieNode[] child = new TrieNode[26];
    }

    private TrieNode root = null;
    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode root = this.root;

        for (char ch : word.toCharArray()) {
            if (root.child[ch - 'a'] == null) {
                root.child[ch - 'a'] = new TrieNode();
            }
            root = root.child[ch - 'a'];
        }
        root.isWord = true;

    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return isMatch(word, 0, this.root);
    }

    private boolean isMatch(String word, int start, TrieNode root) {
        if (root == null) {
            return false;
        }
        if (start == word.length()) {
            return root.isWord;
        }
        
        char ch = word.charAt(start);
        boolean result = false;

        if (ch != '.') {
            return isMatch(word, start + 1, root.child[ch - 'a']);
        } 
        
        for (int i = 0; i < root.child.length; i++) {
            result = isMatch(word, start + 1, root.child[i]) || result;
        }
        
        return result;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */