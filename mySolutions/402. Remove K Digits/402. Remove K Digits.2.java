class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            // pop prev if curr is a smaller number
            while (k > 0 && stack.size() != 0 && stack.peek() > ch) {
                stack.pop();
                k -= 1;
            }
            stack.push(ch);
        }
        // if any k left
        for (int i = 0; i < k && stack.size() != 0; i++) stack.pop();
        // read from stack head;
        Collections.reverse(stack);
        
        while (stack.size() != 0 && stack.peek() == '0') stack.pop(); // pop all 0
        StringBuilder sb = new StringBuilder();
        while (stack.size() != 0) sb.append(stack.pop());

        return (sb.length() == 0) ? "0" : sb.toString();
    }
}