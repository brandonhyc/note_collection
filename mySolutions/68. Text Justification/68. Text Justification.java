class Solution {

    public List<String> fullJustify(String[] words, int mLen) {
        List<String> list = new LinkedList<String>();

        for (int i = 0, w; i < words.length; i = w) {
            int curLen = -1;
            w = i;
            for (; w < words.length && curLen + words[w].length() + 1 <= mLen; w++) {
                curLen += words[w].length() + 1;
                // System.out.printf("curLen %d, mLen: %d\n", curLen, mLen);
            }    

            int space = 1, extra = 0;
            if (w != i + 1 && w != words.length) {
                // only one word or last line
                space = 1 + (mLen - curLen) / (w - i - 1);
                extra = (mLen - curLen) % (w - i - 1);
            } 
            // System.out.printf("space:%d, extra: %d\n", space, extra);
            StringBuilder sb = new StringBuilder(words[i]);
            for (int j = i + 1; j < w; j++) {
                for (int s = 0; s < space; s++) sb.append(' ');
                if (extra > 0) {
                    sb.append(' ');  
                    extra -= 1;
                }
                sb.append(words[j]);
            }

            for (int j = sb.length(); j < mLen; j++) sb.append(' ');
            list.add(sb.toString());
        }
        return list;

    }
}