class Solution {
    public boolean isValid(String s) {
        String left = "([{";
        String right = ")]}";
        
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (right.indexOf(ch) != -1) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() != left.charAt(right.indexOf(ch))) {
                    return false;
                }
                stack.pop();

            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}