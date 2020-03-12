class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        strStack.push(new StringBuilder());
        int num = 0;
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int curNum = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    curNum = curNum * 10 + (s.charAt(i) - '0');
                    i += 1;
                }
                numStack.push(curNum);                
            }
            else if (ch == '[') {
                strStack.push(new StringBuilder());
                i += 1;
            }
            else if (ch == ']') {
                StringBuilder sb = strStack.pop();
                String single = sb.toString();
                int k = numStack.pop();
                for (int j = 1; j < k; j++) sb.append(single);
                sb.insert(0, strStack.pop());
                strStack.push(sb);
                i += 1;
            }
            else if (Character.isLetter(ch)) {
                StringBuilder sb = strStack.pop();
                while (i < s.length() && Character.isLetter(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i += 1;
                }
                strStack.push(sb);
            }
        }

        return strStack.pop().toString();

    }
}