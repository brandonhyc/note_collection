package codingPad;

import java.util.HashMap;
import java.util.Map;

class WordDictionary {

//    / Initialize your data structure here. /
    Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.insert(word);
    }

    public boolean search(String word) {
        return trie.search(word);

    }


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

//        / Inserts a word into the trie. /
        public void insert(String word) {
            Node curr = root;
            for (char ch : word.toCharArray()) {
                curr.children.putIfAbsent(ch, new Node(ch));
                curr = curr.children.get(ch);
            }
            curr.isEnd = true;
        }

//        / Returns if the word is in the trie. /
        public boolean search(String word) {
            return search(root, word, 0);
        }

        private boolean search(Node curr, String word, int cur) {
            while (cur < word.length()) {
                if (word.charAt(cur) != '.') {
                    Node next = curr.children.get(word.charAt(cur));
                    if (next == null) return false;

                    curr = next;
                    cur++;
                } else {
                    boolean res = false;
                    for (Character key : curr.children.keySet()) {
                        Node next = curr.children.get(key);
                        if (next == null) continue;
                        res = res || search(next, word, cur + 1);
                    }

                    return res;
                }
            }

            return curr.isEnd;
        }

//        / Returns if there is any word in the trie that starts with the given prefix. /
        public boolean startsWith(String prefix) {
            Node curr = root;
            for(char ch : prefix.toCharArray()) {
                Node next = curr.children.get(ch);
                if (next == null) return false;

                curr = next;
            }
            return true;
        }

        private class Node {
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
}
