// 典型的dfs backtracking.
// 思路: 因为很容易混乱, 不知道从那个方向dfs. 
//      其实可以从结果出发. input: "34" -> ["dg","dh","di","eg","eh","ei","fg","fh","fi"]
//          观察得, 每个结果是 两个字母. 所以, 从树底往上看, 就是 ""->"d"->"dg" ... "d"->"dh" ... "d"->"di"
//          于是, 每层应该为一个按键三个字母. 那么要做的就是学会字符串和数字与字符的转化
// 难点1: char, String, int
// char 

public class Solution {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        // write your code here

        String[] btn = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> results = new ArrayList<>();

        if (digits.length() == 0) {
            return results;
        }
        dfs(digits, results, btn, 0, "");
        return results;
    }
    private void dfs(String digits, List<String> results, String[] btn, 
                     int startIndex, String combination) {
        if (startIndex == digits.length()) {
            results.add(combination);
            return;
        } // exit;

        int num = digits.charAt(startIndex) - '0';
        for (char c : btn[num].toCharArray()) {
            dfs(digits, results, btn, startIndex + 1, combination + c);
        }
    }
}