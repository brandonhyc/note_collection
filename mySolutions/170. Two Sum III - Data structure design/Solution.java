public class TwoSum {
    /**
     * @param number: An integer
     * @return: nothing
     */

    private ArrayList<Integer> list = new ArrayList<>();
    public void add(int number) {
        
        // write your code here
        list.add(number);
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        Collections.sort(list);
        int left = 0; int right = list.size() - 1;
        while (left < right) {
            if (value == list.get(left) + list.get(right)) {
                return true;
            } else if (value < list.get(left) + list.get(right)) {
                right--;
            } else left++;
        }
        return false;
    }
}
