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
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    int res = 0;
                    if (str.equals("+")) {
                        res = num1 + num2;
                    }
                    else if (str.equals("-")) {
                        res = num2 - num1;
                    }
                    else if (str.equals("*")) {
                        res = num2 * num1;
                    }
                    else if (str.equals("/")) {
                        res = num2 / num1;
                    }
                    else {
                        throw new Exception();    
                    }
                    stack.push(res);
                } catch(Exception e) {
                    System.out.printf("error: failed to compute operation");
                }
            }
            else {
                try {
                    int num = Integer.parseInt(str);
                    stack.push(num);
                } catch(Exception e) {
                    System.out.printf("error: failed to parse Integer \n");
                }
            }
        }
        
        if (stack.size() != 1) {
            System.out.printf("error: too many num input: %s \n", Arrays.toString(stack.toArray()));
        }
        return stack.pop();
    }
}