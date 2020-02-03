## General Idea
Find a target number in a space/range. Reduce the size of the search space by dividing into two half of containing target and not-containing the target. Continue searching in the half (potentially) containing the target. Repeat this process until either we are sure we cannot find the target in the minimized space.

## Question should ask before start
1. input: order? ascend/descend / rotated?
2. input: form? array/list/ stream(infinite)
3. input: will have the target / not .. if smaller, if larger?
4. input: nums can be duplicated / not
5. output: return index / value
6. output: if not found, -1 ?


## Binary Search 二分法查找
```java
    public int lastPosition(int[] nums, int target) {
        // [1,2,2,4,5,5] 2
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;// 2,3
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;//2
            if (nums[mid] == target) { // 4 != 2 nums[mid] > target
                start = mid;
            }
            if (target < nums[mid]) {
                end = mid;
            }
            if (nums[mid] < target) {
                start = mid;
            }
        }

        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
```