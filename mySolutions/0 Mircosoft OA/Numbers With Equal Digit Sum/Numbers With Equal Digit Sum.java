// "static void main" must be defined in a public class.
//https://leetcode.com/discuss/interview-question/365872/
public class Main {
    
    private int maxSumOfEqualDigits(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxVal = -1;
        for (int i = 0; i < nums.length; i++) {
            int dSum = getDigitSum(nums[i]);
            if (!map.containsKey(dSum)) {
                map.put(new Integer(dSum), new ArrayList<>());
            }
            map.get(dSum).add(i);
        }
        System.out.printf("%s\n", Arrays.toString(map.entrySet().toArray()));
        
        for (Integer key: map.keySet()) {
            if (map.get(key).size() <= 1) {
                continue;
            }
            List<Integer> sums = map.get(key);
            Integer larger = -1;
            for (int i = 0; i < sums.size(); i++) {
                if (larger != -1) {
                    maxVal = Math.max(nums[sums.get(i)] + larger, maxVal);
                }
                if (sums.get(i) > larger) {
                    larger = Math.max(nums[sums.get(i)], larger);
                }
            }
        }
        
        return maxVal;
    }
    
    private int getDigitSum(int num) {
        int total = 0;
        while (num != 0) {
            total += num % 10;
            num = num / 10;
        }
        return total;
    }
    public static void main(String[] args) {
        Main sol = new Main();
        int res = sol.maxSumOfEqualDigits(new int[]{51, 71,42,17});
        System.out.printf("%d\n", sol.maxSumOfEqualDigits(new int[]{51, 71,42,17}));
        System.out.printf("%d\n", sol.maxSumOfEqualDigits(new int[]{42, 33, 60}));
        System.out.printf("%d\n", sol.maxSumOfEqualDigits(new int[]{51, 32, 43}));
    }
}