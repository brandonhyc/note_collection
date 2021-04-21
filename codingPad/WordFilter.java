package codingPad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordFilter {
    TrieNode root;
    Map<String, Integer> map;

    public WordFilter(String[] words) {
        root = new TrieNode('#');
        map = new HashMap<>();
        int i = 0;
        for (String word : words) {

            root.insert(word, i);
            map.put(word, i++);
        }

    }

    public int f(String prefix, String suffix) {
        List<TrieNode> list = root.search(prefix).listAllNodes();

        int maxIndex = -1;
        // find all words matching suffix
        for (TrieNode node : list) {
            StringBuilder word = new StringBuilder();
            TrieNode curr = node;
            int suffixIndex = suffix.length() - 1;

            while (curr.parent != null && curr.parent.currCh != '#') {
                if (suffixIndex >= 0 && curr.currCh != suffix.charAt(suffixIndex--)) {
                    break;
                }
                word.insert(0, curr.currCh);
                curr = curr.parent;
            }



            if (curr.parent != null && curr.parent.currCh == '#') {
                maxIndex = Math.max(maxIndex, node.id);
            }
        }

        return maxIndex;
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