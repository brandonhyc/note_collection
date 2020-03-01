// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println((new Solution()).isValidNumber("123"));
        System.out.println((new Solution()).isValidNumber("-123"));
        System.out.println((new Solution()).isValidNumber("+0"));
        System.out.println((new Solution()).isValidNumber(".0"));
        System.out.println((new Solution()).isValidNumber("1.0"));
        System.out.println((new Solution()).isValidNumber("1."));
    }
}


class Solution {

    public boolean isValidNumber(String str) {
        // return true if the input is a valid number
        // a valid number can include sign symbol, point and numbers
        str = str.trim();
        boolean seenSign = false;
        boolean seenNum = false;
        boolean seenPoint = false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case '-':
                case '+':
                    if (i != 0) return false;
                    seenSign = true;
                    break;
                case '.':
                    if (seenPoint) return false;
                    seenNum = false;
                    break;
                default:
                    if (!Character.isDigit(ch)) return false; 
                    seenNum = true;
                    break;
            }
        }
        System.out.printf("str: %s ", str);
        return seenNum;
    } 
}