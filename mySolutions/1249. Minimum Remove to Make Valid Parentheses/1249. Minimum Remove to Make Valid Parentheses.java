class Solution {
    public String minRemoveToMakeValid(String s) {

        Stack<Integer> stack = new Stack<>(); // left parentheses
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (stack.size() != 0) {
                    stack.pop();
                } else {
                    set.add(i);
                }
            }
        }
        while (stack.size() != 0) {
            set.add(stack.pop());
        }
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(i)) {
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}