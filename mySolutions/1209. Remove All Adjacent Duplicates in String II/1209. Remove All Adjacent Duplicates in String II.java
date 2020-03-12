class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        int i = 0;
        
        while (i < s.length()) {
            if (stack.size() == 0 || stack.peek().getKey() != s.charAt(i)) stack.push(new Pair(s.charAt(i), 1));
            else {
                Pair<Character, Integer> prev = stack.pop();
                if (prev.getValue() != k - 1) stack.push(new Pair(prev.getKey(), prev.getValue() + 1));
            }
            i += 1;
        }
        
        Collections.reverse(stack);
        StringBuilder sb = new StringBuilder();
        while (stack.size() != 0) {
            Pair<Character, Integer> p = stack.pop();
            for (int j = 0; j < p.getValue(); j++) {
                sb.append(p.getKey());
            }
        }
        
        return sb.toString();
    }
}