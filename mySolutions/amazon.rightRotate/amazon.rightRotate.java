public static int rightRotat(String word1, String word2) {
    if (word1 == null || word2 == null || word1.length() == 0 || word2.length() == 0) {
        return -1;
    }

    String str = word1 + word1;
    
    if (str.indexOf(word2) != -1) {
        return 1;
    }
    return -1;
}