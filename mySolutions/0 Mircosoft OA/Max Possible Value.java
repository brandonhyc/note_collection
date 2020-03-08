// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(maxNumber(123));
        System.out.println(maxNumber(-123));
        System.out.println(maxNumber(0));
        System.out.println(maxNumber(1));
        System.out.println(maxNumber(-1));
        System.out.println(maxNumber(945));
        System.out.println(maxNumber(439));   
    }
    
    
    static private int maxNumber(int num) {
        boolean isNegative = num < 0;
        String str = String.valueOf(num);
        
        if (isNegative) {
            str = str.substring(1);
            str = new StringBuilder(str).reverse().toString();
        };
        StringBuilder sb = new StringBuilder();
        boolean added5 = false;
        
        for (int i = 0; i < str.length(); i++) {
            if (!added5 && str.charAt(i) < '5') {
                sb.append('5');
                added5 = true;
            };
            sb.append(str.charAt(i));
        }
        if (!added5) sb.append('5');
        
        if (isNegative) {
            sb.append('-');
            sb.reverse();
        }
        
        return Integer.valueOf(sb.toString());        
    }
}