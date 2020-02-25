import java.util.EmptyStackException;
class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();
        Set<String> symbols = new HashSet<>() {{
            add("+");
            add("-");
            add("/");
            add("*");
        }};
        
        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            
            if (symbols.contains(str)) {
                try {
                    int res = 0;
                    if (str.equals("+")) {
                        res = add(stack);
                    }
                    else if (str.equals("-")) {
                        res = minus(stack);
                    }
                    else if (str.equals("*")) {
                        res = multiply(stack);
                    }
                    else if (str.equals("/")) {
                        res = divide(stack);
                    }
                    else { // stack out of bound
                        throw new IllegalArgumentException();    
                    }
                    // System.out.printf("new res: %d\n", res);
                    stack.push(res);
                } catch(IllegalArgumentException | EmptyStackException | ArithmeticException e) {
                    
                }
            }
            else {
                try {
                    int num = Integer.parseInt(str);
                    stack.push(num);
                } catch(Exception e) {
                    
                }
            }
        }
        
        if (stack.size() != 1) {
            System.out.printf("error: too many num input: %s \n", Arrays.toString(stack.toArray()));
        }
        return stack.pop();
    }

    private int add(Stack<Integer> s) {
        int num1 = s.pop();
        int num2 = s.pop();
        return num2 + num1;
    }
    
    private int multiply(Stack<Integer> s) {
        int num1 = s.pop();
        int num2 = s.pop();
        return num2 * num1;
    }
    private int minus(Stack<Integer> s) {
        int num1 = s.pop();
        int num2 = s.pop();
        return num2 - num1;
    }
    
    private int divide(Stack<Integer> s) {
        int num1 = s.pop();
        int num2 = s.pop();
        return num2 / num1;
    }
}
