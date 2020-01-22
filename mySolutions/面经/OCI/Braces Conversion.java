class Solution {
    //https://www.1point3acres.com/bbs/thread-575215-2-1.html
    public String longestValidParentheses(String s) {
        boolean[] invalid = new boolean[s.length()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')' ) {
                if (stack.size() == 0) {
                    invalid[i] = true;   
                } else {
                    stack.pop();
                }
            }
        }
        while (stack.size() != 0) {
            int index = stack.pop();
            invalid[index] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < invalid.length; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
               if (invalid[i]) {
                   sb.append((s.charAt(i) == '(') ? "1" : "-1");
               } else {
                   sb.append(0);
               }
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = ")21(21)a1("; // ANS: -1210210a11
            
            String ret = new Solution().longestValidParentheses(s);
            
            String out = String.valueOf(ret);
            
            System.out.print(ret);
        }
    }
}