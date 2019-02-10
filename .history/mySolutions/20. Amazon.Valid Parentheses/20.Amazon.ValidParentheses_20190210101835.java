class Solution {
    public boolean isValid(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char nextChar = s.charAt(i); 

            if (stack.empty()) {
                stack.push(nextChar);
            } 
            else if (nextChar - stack.peek() == 1 || nextChar - stack.peek() == 2) {
                    stack.pop();
            }
            else {
                stack.push(nextChar);
            }
        }

        return stack.empty();
    }
}