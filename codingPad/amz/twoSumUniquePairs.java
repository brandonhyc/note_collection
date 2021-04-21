package codingPad.amz;

import java.util.Collections;
import java.util.List;

class twoSumUniquePairs {
    public int twoSumUniquePairs(List<Integer> nums, int target) {
        int count = 0;
        Collections.sort(nums);
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum == target) {
                count++;
            }

            if (sum <= target) {
                left++;
                while (left < right && nums.get(left) == nums.get(left - 1)) {
                    left++;
                }
            } else {
                right--;
                while (left < right && nums.get(right) == nums.get(right + 1)) {
                    right--;
                }
            }
        }

        return count;
    }

}