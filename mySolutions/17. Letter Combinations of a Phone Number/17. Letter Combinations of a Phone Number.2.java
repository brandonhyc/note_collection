class Solution {
    Map<Character, String> phone;
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        
        phone = new HashMap<>();
        phone.put('2', "abc");
        phone.put('3', "def");
        phone.put('4', "ghi");
        phone.put('5', "jkl");
        phone.put('6', "mno");
        phone.put('7', "pqrs");
        phone.put('8', "tuv");
        phone.put('9', "wxyz");
        
        List<String> results = new ArrayList<>();
        
        backtrack(results, new StringBuilder(), digits, 0);
        
        return results;
    }
    
    private void backtrack(List<String> results, StringBuilder sb, String digits, int digitsStart) {
        if (digitsStart == digits.length()) {
            results.add(sb.toString());
            return;
        }
        
        
        char digit = digits.charAt(digitsStart);
        // System.out.printf("digits.charAt(digitsStart): %c, phone.get(Character.getNumericValue(digit)): %d\n", digit, phone.get(Character.getNumericValue(digit)));
        String letters = phone.get(digit);
        
        for (int i = 0; i < letters.length(); i++) {
            char ch = letters.charAt(i);
            
            sb.append(ch);
            backtrack(results, sb, digits, digitsStart + 1);
            sb.delete(sb.length() - 1, sb.length());
            
        }
        
        
    } 
}