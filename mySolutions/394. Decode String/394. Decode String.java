class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> factorStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        strStack.push(new StringBuilder());
        
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + Character.getNumericValue(ch);
            }
            else if (ch == '[') {
                StringBuilder sb = new StringBuilder();
                strStack.push(sb);
                factorStack.push(num);
                num = 0;
            } 
            else if (ch == ']') {
                StringBuilder template = strStack.pop();
                StringBuilder str = new StringBuilder();
                int factor = factorStack.pop();
                
                for (int j = 0; j < factor; j++) {
                    str.append(template);
                }
                
                strStack.peek().append(str);
            }
            else if (Character.isLetter(ch)){
                StringBuilder sb = strStack.peek();
                sb.append(ch);
            }
            else {
                System.out.println("error");
            }
            
        }
        
        return strStack.peek().toString();
    }
}