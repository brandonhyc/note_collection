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
                try { // is operand
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    int res = 0;
                    if (str.equals("+")) {
                        res = new Operation(num1, num2, new Plus()).execute();
                    }
                    else if (str.equals("-")) {
                        res = new Operation(num2, num1, new Minus()).execute();
                    }
                    else if (str.equals("*")) {
                        res = new Operation(num2, num1, new Multiply()).execute();
                    }
                    else if (str.equals("/")) {
                        res = new Operation(num2, num1, new Divide()).execute();
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
class Operation {
    int a;
    int b;
    Operand op;
    public Operation(int num1, int num2, Operand op) {
        a = num1;
        b = num2;
        this.op = op;
    }

    public int execute() {
        return this.op.compute(a, b);
    }
}

interface Operand {
    public int compute(int num1, int num2);
}

class Plus implements Operand {
    @Override
    public int compute(int a, int b) {
        return a + b;
    }
}

class Minus implements Operand {
    @Override
    public int compute(int a, int b) {
        return a - b;
    }
}

class Multiply implements Operand {
    @Override
    public int compute(int a, int b) {
        return a * b;
    }
}

class Divide implements Operand {
    @Override
    public int compute(int a, int b) {
        return a / b;
    }
}

public class MainClass {
    public static String[] stringToStringArray(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
          arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] tokens = stringToStringArray(line);
            
            int ret = new Solution().evalRPN(tokens);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}