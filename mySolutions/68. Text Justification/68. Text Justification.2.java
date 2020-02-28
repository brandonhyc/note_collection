class Solution {
    private int[] getPadding(int i, int w, int clen, String[] words, int maxWidth) {
        int space = 1;
        int extra = 0;
        if (w - i - 1 != 0 && w != words.length) {
            space = 1 + (maxWidth - clen) / (w - i - 1);
            extra = (maxWidth - clen) % (w - i - 1);
        }
        return new int[] {space, extra};
    }
    
    private String genLine(int i, int n, int even, int extra, String[] words, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        for (int j = i; j < n; j++) {
            sb.append(words[j]);

            for (int k = 0; k < even && j != n - 1; k++) {
                sb.append(' ');
            }
            if (extra > 0) {
                sb.append(' ');
                extra -= 1;
            }
        }
        
        while (sb.length() < maxWidth) sb.append(' ');
        
        return sb.toString();
    }
    
    private int[] fillWords(int i, String[] words, int maxWidth) {
        int clen = -1;
        int n = i;
        for (; n < words.length && clen + 1 + words[n].length() <= maxWidth; n += 1) clen += words[n].length() + 1;
        return new int[]{n, clen};
    }
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> res = new ArrayList<>();
        
        int i = 0, n = 0;
        for (; i < words.length; ) {
            int clen = -1;
            for (n = i; n < words.length && clen + 1 + words[n].length() <= maxWidth; n += 1) clen += words[n].length() + 1;
            int[] rightEnd = new int[] {n, clen};
            // int[] rightEnd = fillWords(i, words, maxWidth);
            int[] padding = getPadding(i, rightEnd[0], rightEnd[1], words, maxWidth);
            String line = genLine(i, n, padding[0], padding[1], words, maxWidth);
            res.add(line);
            i = rightEnd[0];
        }
        
        return res;
    }
}