class Solution {
    public List<Integer> sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            res.add(nums[i]);
        }
        return res;
    }
    
    private void quicksort(int[] nums, int l, int r) {
        
        if (l < r) {
            int piv = partition(nums, l, r);
        
            quicksort(nums, l, piv - 1);
            quicksort(nums, piv + 1, r);
            
        }
        return;
    }
    
    private int partition(int[] arr, int l, int r) {
        // System.out.printf("%s\n", Arrays.toString(arr));
        // System.out.printf("l: %d, r: %d\n", l, r);
        int low = l - 1;
        int key = arr[r];
        for (int i = l; i < r; i++) {
            if (arr[i] <= key) {
                low += 1;
                int temp = arr[low];
                arr[low] = arr[i];
                arr[i] = temp;
            }
        }
        // System.out.printf("l: %d, r: %d, low: %d\n", l, r, low);
        int temp = arr[low + 1];
        arr[low + 1] = arr[r];
        arr[r] = temp;
        // System.out.printf("after swap %s\n", Arrays.toString(arr));
        return low + 1;
    }
}