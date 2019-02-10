class Solution {
    public boolean isValid(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }

        Stack stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
            } 
            else if () {
                
            }
        }

        return false;


    }
}