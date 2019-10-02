class Solution {
    public int calculate(String s) {
        
        Stack<Integer> valStack = new Stack<>();
        int cur = 0;
        
        char lastSign = '+';
        int lastNum = 0;
        
        while (cur < s.length()) {
            char ch = s.charAt(cur);
            
            if (!Character.isDigit(ch)) { // ops
                if (ch == ' ') {
                    cur++;
                    continue;
                } else {
                    compute(lastSign, lastNum, valStack);    
                }
                
                // reset
                lastNum = 0;
                lastSign = ch;
                cur++;
            }
            else if (Character.isDigit(ch)) {
                lastNum = lastNum * 10 + Character.getNumericValue(ch);
                cur++;
            }
        }
        
        // the last operation needs to be handled
        compute(lastSign, lastNum, valStack);
        
        int sum = 0;
        while (!valStack.isEmpty()) {
            sum += valStack.pop();
        }
        return sum;
    }
    
    private void compute(char lastSign, int lastNum, Stack<Integer> valStack) {
        if (lastSign == '+') {
            valStack.push(lastNum);
        }
        else if (lastSign == '-') {
            valStack.push(-lastNum);
        } 
        else if (lastSign == '*') {
            valStack.push(valStack.pop() * lastNum);
        }
        else if (lastSign == '/') {
            valStack.push(valStack.pop() / lastNum);
        }
    }
}