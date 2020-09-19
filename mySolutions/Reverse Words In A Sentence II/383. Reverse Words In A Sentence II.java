public class Solution {
    public String reverseWords(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        int i = 0, j = 0;

        // leading space
        while (j < input.length() && array[j] == ' ') {
            j++;
        }
        if (j >= array.length) return "";

        // mid
        while (j < input.length()) {
            if (array[j] == ' ') {
                array[i++] = array[j++];
                while (j < input.length() && array[j] == ' ') j++;
            } else {
                array[i++] = array[j++];
            }
        }
        // trailing space
        if (array[i - 1] == ' ') i--;

        char[] compressed = Arrays.copyOf(array, i);

        i = 0;
        while (i < compressed.length) {
            j = i;
            while (j < compressed.length && compressed[j] != ' ') {
                j++;
            }
            reverse(compressed, i, j - 1);
            i = j + 1;
        }

        reverse(compressed, 0, compressed.length - 1);
        return new String(compressed, 0, compressed.length);
    }

    private void reverse(char[] array, int i, int j) {
        while (i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }
}
