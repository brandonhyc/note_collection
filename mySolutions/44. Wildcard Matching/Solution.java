// 真的难, 但九章的答案写的真的好, 很整洁, 很简洁.
// 思路: memorized dfs / dp
//      两个指针si->s, pi->p
//      1. pi 不是 *. 那么就检查 (si) == (pi), 或者 (pi) == ?. 
//            若true, 则用 &&, (si, pi) && (si++, pi++)的结果; 若false, 则 return false;
//      2. pi 是 *. 难点!!!!不会!!!
// 易错点1: boolean[][]初始化, 所有点初始值为false, 不是null


public class Solution {
    /**
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        if (s == null || p == null) {
            return false;
        }

        boolean[][] memo = new boolean[s.length()][p.length()];
        boolean[][] visited = new boolean[s.length()][p.length()];

        return helper(s, p, 0, 0, memo, visited);
    }

    private boolean helper(String s, String p, 
                            int indexS, int indexP,
                            boolean[][] memo,
                            boolean[][] visited) {

        if (indexS == s.length()) {
            // when s end first;
            // func need to be stars
            return isStarTail(p, indexP);
        }

        if (indexP == p.length()) {
            return indexS == s.length();
        }

        if (visited[indexS][indexP]) {
            return memo[indexS][indexP];
        }
        
        char sChar = s.charAt(indexS);
        char pChar = p.charAt(indexP);
        boolean isMatched;

        if (pChar == '*') {
            isMatched = helper(s, p, indexS + 1, indexP, memo, visited) ||
                        helper(s, p, indexS, indexP + 1, memo, visited);
        } else {
            // ? or "a"
            isMatched = charMatch(sChar, pChar) &&
                        helper(s, p, indexS + 1, indexP + 1, memo, visited);
        }

        
        visited[indexS][indexP] = true;
        memo[indexS][indexP] = isMatched;
        return isMatched;
    }

    private boolean charMatch(char s, char p) {
        return (s == p || p == '?');
    }
    private boolean isStarTail(String s, int indexS) {

        for (int i = indexS; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
}