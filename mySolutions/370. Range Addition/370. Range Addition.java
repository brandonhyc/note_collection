// Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
// Output: [-2,0,3,5,3]

class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        if (length == 0) {
            return new int[0];
        }

        int[] array = new int[length];

        for (int[] op : updates) {

            int left = op[0];
            int right = op[1];
            int val = op[2];

            for (int i = left; i <= right; i++) {
                array[i] += val;
            }

        }

        return array;
    }
}