
// 17.02.2018, found: num[mid] < target, does not need to consider case of nums[mid] == target;
public int findMin(int[] nums) {
    if (nums == null || nums.length == 0) {
        return -1;
    }

    int start = 0, end = nums.length -1;
    int target = nums[end];

    while (start + 1 < end) {
        int mid = start + (end - start) /2;
        if (nums[mid] < target) { // 
            end = mid;
        } else if (nums[mid] > target) {
            start = mid;
        } 
    }

    if (nums[start] < nums[end]) {
        return nums[start];
    } 
    return nums[end];

}