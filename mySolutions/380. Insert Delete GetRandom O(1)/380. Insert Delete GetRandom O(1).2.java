
class RandomizedSet {

    Random rand = new Random();
    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> numIndexMap = new HashMap<>();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        Random rand = new Random();
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> numIndexMap = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain
     * the specified element.
     */
    public boolean insert(int val) {
        if (numIndexMap.containsKey(val)) {
            return false;
        }
        int index = list.size();
        list.add(val);
        numIndexMap.put(val, index);

        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified
     * element.
     */
    public boolean remove(int val) {
        if (!numIndexMap.containsKey(val)) {
            return false;
        }
        int index1 = numIndexMap.get(val);
        int index2 = list.size() - 1;
        int num1 = val;
        int num2 = list.get(index2);

        list.set(index1, num2);
        numIndexMap.put(num2, index1);
        
        list.remove(index2);
        numIndexMap.remove(num1);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        // System.out.printf("list: %s\n", list);
        int index = rand.nextInt(list.size());
        return list.get(index); 
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */