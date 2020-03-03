// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int num = 100;
        List<Integer> res = findFactors(num);
        System.out.printf("input: %d, %d in %s\n", num, res.get(3 - 1), Arrays.toString(res.toArray()));
    }
    
    static private List<Integer> findFactors(int num) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) nums.add(i);
            if (num % i == 0 && num / i != i) nums.add(num / i);
        }
        Collections.sort(nums);
        return nums;
    } 
    
}