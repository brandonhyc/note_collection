// "static void main" must be defined in a public class.
//https://leetcode.com/discuss/interview-question/406031/
public class Main {
    public static void main(String[] args) {
        int[] nums1 = { 3, 2, -2, 5, -3 };
        int[] nums2 = { 1, 2, 3, -4 };
        System.out.println(largest(nums1));
        System.out.println(largest(nums2));
    }

    static private int largest(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(-nums[i]))
                max = Math.max(Math.abs(nums[i]), max);
            set.add(nums[i]);
        }
        return max;
    }
}