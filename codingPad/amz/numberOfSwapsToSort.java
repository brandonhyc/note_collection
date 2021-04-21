package codingPad.amz;

import java.util.*;

public class numberOfSwapsToSort {
    public static int numberOfSwapsToSort(List<Integer> nums) {
        int[] numArr = new int[nums.size()];
        int[] res = new int[1];
        for (int i = 0; i < nums.size(); i++) {
            numArr[i] = nums.get(i);
        }
        mergeSort(numArr, 0, numArr.length - 1, new int[numArr.length], res);

        return res[0];
    }

    private static void mergeSort(int[] nums, int start, int end, int[] buffer, int[] desc) {
        if (end <= start) return;

        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid, buffer, desc);
        mergeSort(nums, mid + 1, end, buffer, desc);

        // sort and record when a number from left-hand side is moved after some numbers are placed before it

        int lStart = start, lEnd = mid, rStart = mid + 1, rEnd = end;
        int i = start; // copy num to i
        while (lStart <= lEnd || rStart <= rEnd) {
            if (rStart > rEnd || lStart <= lEnd && nums[lStart] <= nums[rStart]) {
                // copy num from left-hand side
                buffer[i] = nums[lStart++];
                desc[0] += rStart - mid -1; // all numbers within range are smaller nums, mid + 1 is the start point, rStart is the end point
            } else {
                buffer[i] = nums[rStart++];
            }

            i++;
        }

        for (i = start; i <= end; i++) {
            nums[i] = buffer[i];
        }
    }
}
