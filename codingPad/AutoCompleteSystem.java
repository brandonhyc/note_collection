package codingPad;

import java.util.*;

class AutocompleteSystem {

    Node root;
    Node curr;
    Map<String, Integer> timesMap;
    String prefix = "";

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = curr = new Node('!');
        timesMap = new HashMap<>();
        for (int i = 0; i < sentences.length; i++) {
            timesMap.put(sentences[i], times[i]);
            curr.insert(sentences[i]);
        }

    }

    private void savePrefix(String word) {
        int count = timesMap.getOrDefault(word, 0);
        if (count == 0) root.insert(word);
        timesMap.put(word, count + 1);
    }

    public List<String> input(char c) {

        if (c == '#') {
            savePrefix(prefix);
            prefix = "";
            curr = root;
            return new ArrayList<>();
        }

        curr = (curr == null) ? null : curr.search(c);
        if (curr == null) {
            prefix += c;
            return new ArrayList<>();
        }
        List<String> list = curr.listAll();

        for (int i = 0; i < list.size(); i++) {
            list.set(i, prefix + list.get(i));
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int timeA = timesMap.get(a), timeB = timesMap.get(b);
                if (timeA == timeB) {
                    return a.compareTo(b);
                }
                return Integer.compare(timeB, timeA);
            }
        });

        List<String> res = new ArrayList<>();
        for (int i = 0; i < 3 && i < list.size(); i++) {
            res.add(list.get(i));
        }

        prefix += c;
        return res;
    }

    class Node { // trie node

        Character curr;
        boolean isEnd = false;
        Map<Character, Node> children;

        public Node(char ch) {
            curr = ch;
            children = new HashMap<>();
        }

        public void insert(String word) {
            Node curr = this;
            for (char ch : word.toCharArray()) {
                curr.children.putIfAbsent(ch, new Node(ch));
                curr = curr.children.get(ch);
            }
            curr.isEnd = true;
        }

        public List<String> listAll() {

            List<String> all = new ArrayList<>();
            if (this.isEnd) {
                all.add(String.valueOf(this.curr));

            };
            for (Node next : this.children.values()) {
                List<String> words = next.listAll();

                for (String suffix : words) {
                    all.add(curr + suffix);
                }
            }
            return all;
        }

        public Node search(char ch) {
            Node next = this.children.get(ch);
            return next;
        }

    }
}

// ["AutocompleteSystem","input","input","input","input","input","input","input","input","input","input","input","input"]
// [[["i love you","island","iroman","i love leetcode"],[5,3,2,2]],["i"],[" "],["a"],["#"],["i"],[" "],["a"],["#"],["i"],[" "],["a"],["#"]]



