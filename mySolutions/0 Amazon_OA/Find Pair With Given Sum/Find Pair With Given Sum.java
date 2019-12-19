// https://leetcode.com/discuss/interview-question/356960
public class Main {
    
    public static List<Integer> findPair(List<Integer> nums, int target) {
        
        target -= 30;
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        List<Integer> result = Arrays.asList(-1, -1);
        int maxNum = -1;

        for (int i = 0; i < nums.size(); i++) {
            // num1 + num2 = target
            int num1 = nums.get(i);
            int num2 = target - num1;
            if (numIndexMap.containsKey(num2)) {
                // find a pair, record if having larger num
                if (Math.max(num1, num2) > maxNum) {
                    // System.out.printf("num1: %d, num2: %d, maxNum: %d\n", num1, num2, maxNum);
                    maxNum = Math.max(num1, num2);
                    // System.out.printf(" maxNum: %d\n", maxNum);
                    
                    result = Arrays.asList(numIndexMap.get(num2), i);
                }
            }
            numIndexMap.put(num1, i);
        }

        return result;
    }

    public static void main(String[] args) {
        test(Arrays.asList(1, 10, 25, 35, 60), 90); // [2,3]
        test(Arrays.asList(20, 50, 40, 25, 30, 10), 90);//  [1,5]
        test(Arrays.asList(5, 55, 40, 20, 30, 30), 90);// [0,1]
        test(Arrays.asList(50, 20, 10, 40, 25, 30), 90); // [0,2]

    }
    
    private static void test(List<Integer> nums, int target) {
        System.out.println(nums);
        System.out.println(findPair(nums, target));
    }
}