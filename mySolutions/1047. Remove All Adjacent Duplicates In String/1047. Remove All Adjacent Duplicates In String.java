class Solution {
    public String removeDuplicates(String str) {
        int i = 0;
        Stack<Character> stack = new Stack<>();
        while (i < str.length()) {
            if (stack.size() == 0 || stack.peek() != str.charAt(i)) stack.push(str.charAt(i));
            else if (stack.peek() == str.charAt(i)) stack.pop();
            i += 1;
        }
        StringBuilder sb = new StringBuilder();
        Collections.reverse(stack);
        while (stack.size() != 0) sb.append(stack.pop());
        
        return sb.toString();
    }
}