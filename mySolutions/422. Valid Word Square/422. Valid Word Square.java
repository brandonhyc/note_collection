class Solution {
    public boolean validWordSquare(List<String> words) {
        // if kth row and kth column are same string return true
        // i: row, j: col, if m[i][j] = m[j][i] good

        // "abc" i = 0, j = 2 
        // "b"
        if (words.size() == 0) return false;
        
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                if (i < words.size() && j < words.size() && i <= words.get(j).length() - 1 && j <= words.get(i).length() - 1 && words.get(i).charAt(j) == words.get(j).charAt(i)) continue;
                else return false;
            }
        }
        return true;
    }
}