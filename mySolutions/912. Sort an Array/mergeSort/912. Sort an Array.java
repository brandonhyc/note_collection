class Solution {
    
    public List<Integer> sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            res.add(nums[i]);
        }
        return res;

    }

    static void mergeSort(int[] arr, int l, int r) {
        
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    static void merge(int[] arr, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int k = 0;
        int p1 = l;
        int p2 = m + 1;

        while (p1 <= m && p2 <= r) {
            if (arr[p1] <= arr[p2]) {
                temp[k] = arr[p1];
                p1 += 1;
            } else {
                temp[k] = arr[p2];
                p2 += 1;
            }

            k += 1;
        }

        while (p1 <= m) {
            temp[k] = arr[p1];
            p1 += 1;
            k += 1;
        }

        while (p2 <= r) {
            temp[k] = arr[p2];
            p2 += 1;
            k += 1;
        }

        for (int i = 0; i < temp.length; i++) {
            arr[l + i] = temp[i];
        }
        // System.out.printf("merge l %d, m: %d, r: %d %s\n", l, m, r, Arrays.toString(arr));
    } 
}