class Solution {
    public boolean isNumber(String s) {
        boolean seenSymbol = false;
        boolean seenNum = false;
        boolean seenE = false;
        boolean seenDot = false;
        
        s = s.trim();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '+' || ch == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
                seenSymbol = true;
            }
            else if (ch == 'e') {
                if (!seenNum || seenE) return false;
                seenE = true;
                seenNum = false;
                seenSymbol = false;
            }
            else if (ch == '.') {
                if (seenDot || seenE) return false;
                seenDot = true;
            }
            else if (Character.isDigit(ch)) {
                seenNum = true;
            }
            else return false;
            
        }
        
        return seenNum;
    }
}


class Solution {
    public boolean isNumber(String s) {
        boolean seenSymbol = false;
        boolean seenNum = false;
        boolean seenE = false;
        boolean seenDot = false;
        
        s = s.trim();
        try {
            
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '+' || ch == '-') {
                    if (i != 0 && s.charAt(i - 1) != 'e') throw new Exception("illeage symbol");
                    seenSymbol = true;
                }
                else if (ch == 'e') {
                    if (!seenNum || seenE) throw new Exception("illeage 'e'");;
                    seenE = true;
                    seenNum = false;
                    seenSymbol = false;
                }
                else if (ch == '.') {
                    if (seenDot || seenE) throw new Exception("illeage '.' ");;
                    seenDot = true;
                }
                else if (Character.isDigit(ch)) {
                    seenNum = true;
                }
                else throw new Exception("illeage char: " + ch);

            }
        } catch (Exception e) {
            System.out.printf("%s\n", e.getMessage());
            return false;
        }
        
        return seenNum;
    }
}