class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> res = new ArrayList<>();
        for (int i = 0, w; i < words.length; i = w) {
            int llen = -1;
            for (w = i; w < words.length && llen + 1 + words[w].length() <= maxWidth; w += 1) llen += words[w].length() + 1;
            
            int space = 1;
            int extra = 0;
            
            if (w - i - 1 != 0 && w != words.length) {
                space = 1 + (maxWidth - llen) / (w - i - 1);
                extra = (maxWidth - llen) % (w - i - 1);
            }
            
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < w; j++) {
                sb.append(words[j]);
                
                for (int k = 0; k < space && j != w - 1; k++) {
                    sb.append(' ');
                }
                if (extra > 0) {
                    sb.append(' ');
                    extra -= 1;
                }
            }
            
            while (sb.length() < maxWidth) sb.append(' ');
            
            res.add(sb.toString());
        }
        
        return res;
    }
}