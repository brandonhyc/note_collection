class Solution {
    static Map<Character, Character> map = new HashMap<Character, Character>() {
        {
            put(']', '[');
            put(')', '(');
            put('}', '{');
        }
    };

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack();
        boolean result = true;

        for (char rightP : s.toCharArray()) {
            if (!map.containsKey(rightP)) {
                stack.push(rightP);
            } else {
                char leftP = map.get(rightP);
                result = result && !stack.isEmpty() && leftP == stack.pop();
            }
        }

        return result && stack.isEmpty();
    }
}