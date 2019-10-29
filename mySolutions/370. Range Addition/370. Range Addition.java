class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        
        // edge case
        if (length == 0) {
            return new int[0];
        }
        
        int[] array = new int[length];
        // normal
        // 1. set up all operation
        for (int[] tuple : updates) {
            int start = tuple[0];
            int end = tuple[1] + 1;
            int inc = tuple[2];
            
            array[start] += inc;
            if (end <= length - 1) {
                array[end] += -inc;
            }
        }
        // System.out.printf("%s\n", Arrays.toString(array));
        
        
        // 2, add all
        int curInc = 0;
        for (int i = 0; i < array.length; i++) {
            curInc += array[i];
            array[i] = curInc;
        }
        
        return array;
    }
}
