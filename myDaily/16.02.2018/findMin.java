public int findMin(int[] nums){

    if (nums == null || nums.length == 0 {
        return -1;
    }
    int start = 0, end = nums.length -1 ;
    int rightEnd = nums[end];
    int leftEnd = nums[start];

    while ( start + 1 < end) {
        int mid = start + (end - start)/2;
        if (nums[mid] == rightEnd) {
            end = mid;
        } else if (nums[mid] < rightEnd){
            end = mid;
        } else {
            start = mid;
        }
    }

    if (nums[start] < nums[end]){
        return nums[start];
    }

    return nums[end];
}