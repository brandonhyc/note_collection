public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here

        if (numbers == null || numbers.length < 3)
            return null;
        Arrays.sort(numbers);
        List<List<Integer>> resList = new ArrayList<>();

        for (int i = 0; i < numbers.length - 2; i++) {
            
            int sum = -numbers[i], start = i + 1, end = numbers.length - 1;
            while (start < end) {
                if (numbers[start] + numbers[end] == sum) {
                    addCombTo(resList, numbers[i], numbers[start], numbers[end]);
                    start++;
                    end--;
                    while (numbers[start] == numbers[start - 1] && start < end)
                        start++;
                    while (numbers[end] == numbers[end + 1] && start < end)
                        end--;
                } else if (numbers[start] + numbers[end] < sum) {
                    start++;
                } else {
                    end--;
                }
            }
            while (numbers[i] == numbers[i + 1] && i < numbers.length - 2)
                i++;
        }

        return resList;
    }

    private static void addCombTo(List list, int a, int b, int c) {
        List<Integer> temp = new ArrayList<>(Arrays.asList(a, b, c));
        list.add(temp);
    }
}