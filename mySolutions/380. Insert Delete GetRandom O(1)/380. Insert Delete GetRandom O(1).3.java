class RandomizedSet {

    /** Initialize your data structure here. */
    
    Map<Integer, Integer> map;
    List<Integer> vals;
    Random rand;
    public RandomizedSet() {
        map = new HashMap<>();
        vals = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, vals.size());
        vals.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int lastVal = vals.get(vals.size() - 1);
        vals.set(index, lastVal);
        vals.remove(vals.size() - 1);
        map.put(lastVal, index);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return vals.get(rand.nextInt(vals.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */