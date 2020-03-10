// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println(moveA("WRRWWR")); // 2
        System.out.println(moveA("WWRWWWRWR")); // 4
        System.out.println(moveA("WWW")); // 0
        System.out.println(moveA("RW")); // 0
        System.out.println(moveA("R")); //0
        System.out.println(moveA(""));  // 0
    }
    /*
        Initial thought: Use two pointer left and right. Left end start from 0 move toward right stop at where not R, right is in the opposite way. Left should always smaller than right. Iterate all char between left + 1 to right - 1, move all the new encounter 'R' left if it's closer to left, else move to the right. 
    */
    
    private static int moveA(String str) {
        int reds = 0;
        int move = 0;
        for (char ch : str.toCharArray()) if (ch == 'R') reds += 1;
        
        int l = 0;
        int r = str.length() - 1;
        
        while (l < r) {
            if (str.charAt(l) == 'R' && str.charAt(r) == 'R') {
                reds -= 2;
                move += r - l - 1 - reds;
                l += 1;
                r -= 1;
            } else if (str.charAt(l) != 'R') {
                l += 1;
            } else {
                r -= 1;
            }
        }
        
        return move;
    }
    
}