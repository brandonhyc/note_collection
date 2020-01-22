class Solution {
    public int compress(char[] chars) {
        
        int ansIndex = 0;
        int charIndex = 0;
        
        while (charIndex < chars.length) {
            char curChar = chars[charIndex];
            int count = 0;
            
            while (charIndex < chars.length && chars[charIndex] == curChar) {
                charIndex += 1;
                count += 1;
            }
            
            // paste curChar
            chars[ansIndex] = curChar;
            ansIndex += 1;
            
            if (count != 1) {
                char[] chArr = String.valueOf(count).toCharArray();
                for (int i = 0; i < chArr.length; i++) {
                    chars[ansIndex] = chArr[i];
                    ansIndex += 1;
                }
            }
            
        }
        
        return ansIndex;        
    }
}