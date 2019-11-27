class TwoSum {
    List<Integer> list = new ArrayList<>();
    /** Initialize your data structure here. */
    Map<Integer, Integer> map = new HashMap<>();
    
    public TwoSum() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, list.size());
        list.add(number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int i = 0; i < list.size(); i ++) {
            int index = map.getOrDefault(value - list.get(i), -1);
            
            if (index != -1 && index != i) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */