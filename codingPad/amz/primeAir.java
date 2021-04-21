package codingPad.amz;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class primeAir {
//    arr1 = { {1, 2000}, {2, 3000}, {3, 4000} }
//    arr2 = { { 1, 5000 }, {2, 3000} }
//    the first element of every pair represents id and the second value represents the value.
//    and a target x = 5000


    public List<int[]> primeAir(int[][] arr1, int[][] arr2, int target) {
        Arrays.sort(arr2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        List<int[]> res = new ArrayList<>();
        int max = 0;

        for (int i = 0; i < arr1.length; i++) {
            int startIdx = search(arr2, target - arr1[i][1]);
            if (arr2[startIdx][1] + arr1[i][1] >= max) {
                if (arr2[startIdx][1] + arr1[i][1] > max) {
                    res = new ArrayList<>();
                    max = arr2[startIdx][1] + arr1[i][1];
                }
                res.add(new int[] {arr1[i][0], arr2[startIdx][0]});
                startIdx++;

                while (startIdx < arr2.length && arr2[startIdx - 1][1] == arr2[startIdx][1]) {
                    res.add(new int[] {arr1[i][0], arr2[startIdx][0]});
                    startIdx++;
                }
            }
        }

        return res;
    }

    private int search(int[][] arr, int target) { // search the start index in arr2 less or equal target
        int left = 0, right = arr.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid][1] == target) {
                right = mid;
            } else if (arr[mid][1] < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        if (arr[left][1] == target || arr[right][1] > target || arr[left][1] == arr[right][1]) {
            return left;
        }

        return right;
    }
}
