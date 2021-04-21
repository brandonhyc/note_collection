package codingPad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MagicDictionary {

//    / Initialize your data structure here. /
    TrieNode root;
    public MagicDictionary() {
        root = new TrieNode('#');
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            root.insert(word);
        }
    }

    public boolean search(String searchWord) {
        return canFind(searchWord, 0, root, false);
    }

    private boolean canFind(String searchWord, int curr, TrieNode root, boolean hasChanged) {
        // exit
        if (curr == searchWord.length()) {
            if (hasChanged && root.isEnd) return true;

            return false;

        }
        // recursive rule
        for (TrieNode child : root.children.values()) {
            if (child.currCh != searchWord.charAt(curr)) {
                if (hasChanged) continue;
                if (canFind(searchWord, curr + 1, child, true)) return true;
            } else {
                if (canFind(searchWord, curr + 1, child, hasChanged)) return true;
            }

        }
        // do not change
        return false;
    }



    public class TrieNode {

        Character currCh;
        boolean isEnd = false;
        Map<Character, TrieNode> children;
        TrieNode parent;
        Integer id;

        public TrieNode(char ch) {
            currCh = ch;
            children = new HashMap<>();
        }

        public void insert(String word, int id) {
            TrieNode curr = this;
            for (char ch : word.toCharArray()) {
                curr = curr.insert(ch);
            }
            curr.isEnd = true;
            curr.id = id;
        }

        public void insert(String word) {
            TrieNode curr = this;
            for (char ch : word.toCharArray()) {
                curr = curr.insert(ch);
            }
            curr.isEnd = true;
        }

        public TrieNode insert(char ch) {
            this.children.putIfAbsent(ch, new TrieNode(ch));

            TrieNode next = this.children.get(ch);
            next.parent = this;
            return next;
        }

        public List<String> listAll() {

            List<String> all = new ArrayList<>();
            if (this.isEnd) {
                all.add(String.valueOf(this.currCh));

            };
            for (TrieNode next : this.children.values()) {
                List<String> words = next.listAll();

                for (String suffix : words) {
                    all.add(currCh + suffix);
                }
            }
            return all;
        }

        public List<TrieNode> listAllNodes() {

            List<TrieNode> all = new ArrayList<>();
            if (this.isEnd) {
                all.add(this);
            };

            for (TrieNode next : this.children.values()) {
                List<TrieNode> nextNodes = next.listAllNodes();
                all.addAll(nextNodes);
            }

            return all;
        }

        public TrieNode search(char ch) {
            TrieNode next = this.children.get(ch);
            return next;
        }

        public TrieNode search(String word) {

            TrieNode curr = this;
            for(char ch : word.toCharArray()) {
                if (curr == null) return null;
                TrieNode next = curr.children.get(ch);
                curr = next;
            }
            return curr;
        }


        public boolean contains(String word) {
            TrieNode curr = this;
            for(char ch : word.toCharArray()) {
                TrieNode next = curr.children.get(ch);
                if (next == null) return false;

                curr = next;
            }
            return curr.isEnd;
        }
    }
}

