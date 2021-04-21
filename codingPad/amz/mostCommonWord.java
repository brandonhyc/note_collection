package codingPad.amz;

import java.util.*;

public class mostCommonWord {
    class Solution {
        public  String mostCommonWord(String paragraph, List<String> banned) {
            String lowerPag = paragraph.toLowerCase();
            Set<String> bannedSet = new HashSet<>(banned);
            Map<String, Integer> freq = new HashMap<>();

            int i = 0;
            while (i < lowerPag.length()) { // parsing each word by using idx i

                // skipping symbols
                while (i < lowerPag.length() && !Character.isLetter(lowerPag.charAt(i))) {
                    i++;
                }

                int j = i;
                StringBuilder sb = new StringBuilder();
                while (j < lowerPag.length() && Character.isLetter(lowerPag.charAt(j))) {
                    sb.append(lowerPag.charAt(j));
                    j++;
                }
                if (j == i) break; // read all words;
                String word = sb.toString();
                if (!bannedSet.contains(word)) {
                    freq.put(word, freq.getOrDefault(word, 0) + 1);
                }
                i = j;

            }

            int max = 0;
            String maxFreqStr = "";
            for (Map.Entry<String, Integer> en : freq.entrySet()) {
                if (en.getValue() > max) {
                    maxFreqStr = en.getKey();
                    max = en.getValue();
                }
            }
            return maxFreqStr;
        }

    }


}
