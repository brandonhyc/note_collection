public class RandomizedSet {
    Set<Integer> set;

    public RandomizedSet() {
        // do intialization if necessary
         this.set = new HashSet<>();
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        // write your code here
        return set.add(val);
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        // write your code here
        return set.remove(val);

    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        // write your code here
        
        Object[] array = set.toArray();

        int random = (int) (Math.random() * set.size());

        return (int) array[random];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param = obj.insert(val);
 * boolean param = obj.remove(val);
 * int param = obj.getRandom();
 */