class AutocompleteSystem {

    class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children;
        Map<String, Integer> counts;

        TrieNode() {
            isWord = false;
            children = new HashMap<>();
            counts = new HashMap<>();
        }
    }

    TrieNode root;
    String prefix;
    
    public AutocompleteSystem(String[] logs, int[] times) {
        prefix = "";
        root = new TrieNode();
        for(int i = 0; i < logs.length; i ++) {
            insert(logs[i], times[i]);
        }
    }
    
    void insert(String s, int count) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
            cur.counts.put(s, cur.counts.getOrDefault(s, 0) + count);
        }
        cur.isWord = true;
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            insert(prefix, 1);
            prefix = "";
            return new ArrayList<>();
        }
        prefix = prefix + c;
        
        TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
            if (!cur.children.containsKey(ch)) {
                return new ArrayList<>();
            }

            cur = cur.children.get(ch);
        }

        // System.out.printf("prefix: %s, %s\n", prefix, Arrays.toString(cur.counts.entrySet().toArray()));
        PriorityQueue<Map.Entry<String, Integer>> maxheap = new PriorityQueue<>((a, b) -> b.getValue() == a.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        for (Map.Entry<String, Integer> en : cur.counts.entrySet()) {
            maxheap.offer(en);
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (maxheap.size() != 0) {
                Map.Entry<String, Integer> en = maxheap.poll();
                int count = en.getValue();
                res.add(en.getKey());
                // System.out.printf("%d", count);
            }
        }
        // System.out.println(" ");

        return res;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */