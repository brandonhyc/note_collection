public class TwoSum {
    /**
     * @param number: An integer
     * @return: nothing
     */
    
    List<Integer> list;
    public void TwoSum() {
        this.list = new ArrayList<>();
        
    }

    public void add(int number) {
        // write your code here
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        list.add(number);        
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        Collections.sort(this.list);
        
        int left = 0, right = list.size() - 1;

        while (left < right) {
            if (list.get(left) + list.get(right) == value) {
                return true;
            }
            if (list.get(left) + list.get(right) < value) {
                left++;
            } else if (list.get(left) + list.get(right) > value) {
                right--;
            }
        }
        return false;
    }
}