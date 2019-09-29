class Solution {
    public int evalRPN(String[] tokens) {
        
        String ops = "+-*/";
        int i = 0;
        Stack<String> stack = new Stack<>();
        
        while (i < tokens.length) {
            stack.push(tokens[i]);
            
            if (ops.indexOf(stack.peek()) != -1) {
                
                String op = stack.pop();
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                
                stack.push("" + compute(op, a, b));
            }
            i++;
        }
        
        return Integer.valueOf(stack.pop());
    }
    
    private int compute(String op, int a, int b) {
        if (op.equals("+")) {
            return a + b;
        }
        if (op.equals("-")) {
            return b - a;
        }
        if (op.equals("*")) {
            return b * a;
        }
        if (op.equals("/")) {
            return b / a;
        }
        return -1;
    }
}