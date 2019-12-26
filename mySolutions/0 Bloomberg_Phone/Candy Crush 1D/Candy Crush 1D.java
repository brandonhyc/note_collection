import java.util.*;

public class CandyCrush {

    private static String candyCrush(String candies) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < candies.length(); i++) {
            // every time we put a new candy, check and crush
            char c = candies.charAt(i);
            stack.push(c);

            while (canCrush(stack)) {
                stack.pop();
                stack.pop();
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() != 0) {
            sb.insert(0, stack.pop());
        }

        return String.join("", sb);
    }

    static private boolean canCrush(Stack<Character> stack) {
        if (stack.size() < 3) {
            return false;
        }
        char a = stack.pop();
        char b = stack.pop();
        char c = stack.pop();
        stack.push(c);
        stack.push(b);
        stack.push(a);

        return a == b && b == c;
    }

    public static void main(String[] args) {
        System.out.println(candyCrush("aaabbbc")); // c
        System.out.println(candyCrush("aabbbacd")); // cd
        System.out.println(candyCrush("aaabbbacd")); // acd
        System.out.println(candyCrush("aaaaaaaaaabbbbbbbbbbbbbbbbbacd")); // abbacd
    }
}