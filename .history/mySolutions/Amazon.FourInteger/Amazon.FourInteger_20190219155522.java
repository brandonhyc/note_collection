public class Solution {

    // 题目： Given four integers, make F(S) = abs(S[0]-S[1])+abs(S[1]-S[2])+abs(S[2]-S[3]) to be largest

    public int[] FourInteger(int[] inputs) {
        int[] results = new int[4];
        results = Arrays.copyOfRange(inputs, 0, inputs.length)
        results.sort();
        swap(results, 0, 1);
        swap(results, 2, 3);
        swap(results, 0, 3);
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
    }
}