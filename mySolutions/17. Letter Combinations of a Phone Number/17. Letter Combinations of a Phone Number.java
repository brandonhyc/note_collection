class Solution {
    Map<String, String> phone = new HashMap<>();

    
    public List<String> letterCombinations(String digits) {
        
        phone.put("2", "abc");
        phone.put("3", "def");
        phone.put("4", "ghi");
        phone.put("5", "jkl");
        phone.put("6", "mno");
        phone.put("7", "pqrs");
        phone.put("8", "tuv");
        phone.put("9", "wxyz");
        
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }
        List<String> results = new ArrayList<>();
        
        dfs(digits, results, 0, "");
        
        return results;
        
    }
    
    private void dfs(String digits, List<String> results, int index, String prefix) {
        if (index > digits.length()) {
            return;
        }
        if (index == digits.length()) {
            results.add(new String(prefix));
            return;
        }
        
        String digit = digits.substring(index, index + 1);
        String letters = phone.get(digit);
        
        for (int i = 0; i < letters.length(); i++) {
            String combination = prefix + letters.charAt(i);
            dfs(digits, results, index + 1, combination);
        }
        return;
    }
}