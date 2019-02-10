class Solution {
    public boolean isValid(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }

        Stack stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            char nextChar = s.charAt(i); 
            char lastChar = stack.peek();
            if (stack.empty()) {
                stack.push();
            } 
            else if (nextChar) {

            }
        }

        return false;


    }
}