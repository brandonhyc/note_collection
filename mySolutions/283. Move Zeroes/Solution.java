import java.util.ArrayList;

public class Solution {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i : nums) {
            if (i != 0) {
                list.add(i);
            } else count++;
        }
        for (int i = 0; i < count; i++) {
            list.add(0);
        }

        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return;

    }
}