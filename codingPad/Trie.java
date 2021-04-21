package codingPad;

import java.util.HashMap;
import java.util.Map;

class Trie {
    @Override
    public String toString() {
        return "Trie{" +
                "root=" + root +
                '}';
    }

    Node root;
    public Trie() {
        root = new Node('!');
    }

//    / Inserts a word into the trie. /
    public void insert(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            curr.children.putIfAbsent(ch, new Node(ch));
            curr = curr.children.get(ch);
        }
        curr.isEnd = true;
    }

//    / Returns if the word is in the trie. /
    public boolean search(String word) {
        Node curr = root;
        for(char ch : word.toCharArray()) {
            Node next = curr.children.get(ch);
            if (next == null) return false;

            curr = next;
        }
        return curr.isEnd;
    }

//    / Returns if there is any word in the trie that starts with the given prefix. /
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char ch : prefix.toCharArray()) {
            Node next = curr.children.get(ch);
            if (next == null) return false;

            curr = next;
        }
        return true;
    }

    public String getRoot(String word) {
        Node curr = root;
        StringBuilder rootSb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            Node next = curr.children.get(word.charAt(i));
            if (next == null) return null;

            rootSb.append(next.curr);
            if (next.isEnd) {
                return rootSb.toString();
            } else {
                curr = next;
            }
        }
        return null;
    }

    private static class Node {
        Character curr;
        boolean isEnd = false;
        Map<Character, Node> children;

        public Node(char ch) {
            curr = ch;
            children = new HashMap<>();
        }

        @Override
        public String toString() {
            return "Node{" +
                    "curr=" + curr +
                    ", isEnd=" + isEnd +
                    ", children=" + children +
                    '}';
        }
    }
}

///
//  Your Trie object will be instantiated and called as such:
//  Trie obj = new Trie();
//  obj.insert(word);
//  boolean param_2 = obj.search(word);
//  boolean param_3 = obj.startsWith(prefix);
// /