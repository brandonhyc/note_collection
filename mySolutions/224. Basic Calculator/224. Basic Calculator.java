class Solution {
    public int calculate(String s) {

        Stack<Integer> valueStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        
        valueStack.add(0);
        
        int cur = 0;
        while (cur < s.length()) {
            char ch = s.charAt(cur);
            // System.out.printf("s: %s, cur: %d, ch: %c, valueStack: %s, opStack: %s\n", s, cur, ch, valueStack.toString(), opStack.toString());
            
            if (Character.isDigit(ch)) {
                int num = Character.getNumericValue(ch);
                int end = cur + 1;
                while (end < s.length() && Character.isDigit(s.charAt(end))) {
                    num = num * 10 + Character.getNumericValue(s.charAt(end));
                    end++;
                }
                // System.out.printf("   num: %d, cur: %d, end: %d\n", num, cur, end);
                cur = end - 1;
                if (!opStack.isEmpty() && opStack.peek() == '+') {
                    num += valueStack.pop();
                    opStack.pop();
                }
                else if (!opStack.isEmpty() && opStack.peek() == '-') {
                    num = valueStack.pop() - num;
                    opStack.pop();
                }
                valueStack.push(num);
                
            }
            else if (ch == ')') {

                opStack.pop(); // get ride of (
                if (!opStack.isEmpty()) {
                    int val = valueStack.pop();

                    char op = opStack.pop();
                    if (op == '+') {
                        val = valueStack.pop() + val;
                    }
                    else if (op == '-') {
                        val = valueStack.pop() - val;
                    }
                    valueStack.push(val);
                }
            }
            else if (ch == ' ') {
                
            }
            else {
                opStack.push(ch);
            }
            
            cur++;
        }
        
        
        return valueStack.peek();
        
    }
}