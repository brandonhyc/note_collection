class Trie {
    static class TrieNode {
        TrieNode[] children;;
        boolean isEndOfWord;
        public TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }
    
    TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
         root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        TrieNode head = root;
        
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (head.children[index] == null) {
                head.children[index] = new TrieNode();
            }
            head = head.children[index];
        }
        head.isEndOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        boolean isValid = true;
        TrieNode head = root;
        
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            
            if (head.children[index] == null) {
                isValid = false;
                break;
            }
            head = head.children[index];
        }
        
        return head != null && isValid && head.isEndOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        boolean isValid = true;
        TrieNode head = root;
        
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            
            if (head.children[index] == null) {
                isValid = false;
                break;
            }
            head = head.children[index];
        }
        
        return head != null && isValid;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */