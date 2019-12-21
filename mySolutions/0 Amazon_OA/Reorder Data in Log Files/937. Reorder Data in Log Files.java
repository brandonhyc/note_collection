class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (l1, l2) -> {
            String[] split1 = l1.split(" ", 2);
            String[] split2 = l2.split(" ", 2);

            boolean isL1Letter = isLetterLog(split1);
            boolean isL2Letter = isLetterLog(split2);

            if (!isL1Letter && isL2Letter) {
                return 1;
            }
            if (isL1Letter && !isL2Letter) {
                return -1;
            }
            if (isL1Letter && isL2Letter) {
                int comp = split1[1].compareTo(split2[1]);
                if (comp == 0) {
                    return split1[0].compareTo(split2[0]);
                }
                return comp;
            }

            return 0;
        });


        return logs;
    }

    private boolean isLetterLog(String[] split) {
        return Character.isLetter(split[1].charAt(0));
    }
}