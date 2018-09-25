// 思路: 首先也是memorized dfs, 应当参考wildcard的模板
//      区分三种情况s可能出现, "x" | "." | "x*". "x*"为最难情况
//      对于"x*", 要分为 a.若"x*"不match任何字符 indexS 不变, 跳过该"x*". 
//                     b. match一个字符, 向下. indexS + 1, indexP不变
// 易错点1: s == s.length()出口, 要判断p的尾部. 而p的尾巴应该有两种情况. 
//         a. indexP 指向最后一个字母, return false;
//         b. indexP指向途中, 见到*, 因此, 需要主要跳一个空格, indexP += 2;

public class Solution {
    /**
     * @param s: A string
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {

        if (s.length() == 0 || p.length() == 0) {
            return false;
            // ask: how about both are null?
        }

        // memorized dfs
        // since return boolean, I use boolean[][]
        boolean[][] memo = new boolean[s.length()][p.length()];
        boolean[][] visited = new boolean[s.length()][p.length()];
        System.out.println("status: s | p | indexS | indexP | matched?");
        
        return helper(s, p, 0, 0, memo, visited);
    }
    private boolean helper(String s, String p,
                        int indexS, int indexP, 
                        boolean[][] memo, boolean[][] visited){
        
        boolean matched;

        if (indexS == s.length()){
            System.out.printf("status: %s | %s | %d | %d | indexS end\n", s,p, indexS, indexP);

            return isStarTail(p, indexP);
        } // exit
        if (indexP == p.length()) {
            System.out.printf("status: %s | %s | %d | %d | indexP end\n", s,p, indexS, indexP);
            return indexS == s.length(); // false;
        }

        if (visited[indexS][indexP]) {
            return memo[indexS][indexP];
        }
        if (indexP + 1 < p.length() &&
            p.charAt(indexP + 1) == '*') {
            matched = helper(s, p, indexS, indexP + 2, memo, visited) ||
                      charsMatch(s, p, indexS, indexP) && helper(s, p, indexS + 1, indexP, memo, visited);
            System.out.printf("status: %s | %s | %d | %d | * %s\n", s,p, indexS, indexP, matched );

        } else {
            matched = charsMatch(s, p, indexS, indexP) && 
                      helper(s, p, indexS + 1, indexP + 1, memo, visited );
            System.out.printf("status: %s | %s | %d | %d | ? %s\n", s,p, indexS, indexP, matched);

        }

        visited[indexS][indexP] = true;
        memo[indexS][indexP] = matched;
        System.out.printf("now match is  %s\n", matched);
        
        return matched;
    }
    private boolean charsMatch(String s, String p, int indexS, int indexP) {
        if (s.charAt(indexS) == p.charAt(indexP)) {
            return true;
        }
        System.out.printf("chars does not match, \"%s\", match .:%s \n",s.charAt(indexS), s.charAt(indexS) == '.');
        return p.charAt(indexP) == '.';
    }

    private boolean isStarTail(String p, int indexP) {

        for (int i = indexP; i < p.length(); i = i + 2) {
            if (i + 1 == p.length() || p.charAt(i + 1) != '*') {
                return false;
            }
        }
        return true;
    }
}