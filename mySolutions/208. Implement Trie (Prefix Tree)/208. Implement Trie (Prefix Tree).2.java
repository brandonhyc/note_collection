class Trie {

    /** Initialize your data structure here. */
    boolean isWord = false;
    Trie[] child = new Trie[26];
    
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie root = this;
        for (char ch : word.toCharArray()) {
            if (root.child[ch - 'a'] == null) {
                root.child[ch - 'a'] = new Trie();
            }
            root = root.child[ch - 'a'];
        }
        root.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return isMatch(word, 0, this);
    }
    
    private boolean isMatch(String word, int start, Trie root) {
        if (root == null) {
            return false;
        }
        if (word.length() == start) {
            return root.isWord;
        }
        
        return isMatch(word, start + 1, root.child[word.charAt(start) - 'a']);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie root = this;

        for (char ch : prefix.toCharArray()) {
            if (root == null) {
                break;
            }
            root = root.child[ch - 'a'];    
        }

        return root != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */