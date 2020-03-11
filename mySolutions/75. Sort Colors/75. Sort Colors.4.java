// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortColors(new int[] { 1, 2, 3, 0, 0, 1, 2, 0, 3, 2, 3, 1, 2 })));
    }

    static public int[] sortColors(int[] nums) {

        int i = 0; // [0, i) are all 0
        int j = nums.length - 1; // (j, end] are all 3
        int m = i; // m is in [i, j] can be 1 or 2
        while (m <= j) {
            if (m < i)
                m += 1;
            else if (nums[m] == 2 || nums[m] == 1)
                m += 1;
            else if (nums[m] == 0) {
                int tmp = nums[i];
                nums[i] = nums[m];
                nums[m] = tmp;
                i += 1;
            } else if (nums[m] == 3) {
                int tmp = nums[j];
                nums[j] = nums[m];
                nums[m] = tmp;
                j -= 1;
            }
        }

        // from [i, j] are all 1 or 2, swap again
        // make all [i, i') be
        while (i < j) {
            if (nums[i] == 1)
                i += 1;
            else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j -= 1;
            }
        }
        return nums;
    }
}