package codingPad;

import java.util.*;

class RandomizedCollection {

//    / Initialize your data structure here. /
    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random rm;
    public RandomizedCollection() {
        // List vals
        // Map<Val, Set<Index>>
        list = new ArrayList<>();
        map = new HashMap<>();
        rm = new Random();
    }

//    / Inserts a value to the collection. Returns true if the collection did not already contain the specified element. /
    public boolean insert(int val) {
        map.putIfAbsent(val, new HashSet<>());
        boolean existence = map.get(val).size() == 0;

        list.add(val);
        map.get(val).add(list.size() - 1);
        return existence;
    }

//    / Removes a value from the collection. Returns true if the collection contained the specified element. /
    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).size() == 0) return false;
        int lastVal = list.get(list.size() - 1);
        int removal = map.get(val).iterator().next(); // index

        map.get(lastVal).add(removal);
        map.get(lastVal).remove(list.size() - 1);
        map.get(val).remove(removal);

        list.set(removal, lastVal);
        list.remove(list.size() - 1);
        return true;
    }

//    / Get a random element from the collection. /
    public int getRandom() {
        return list.get(rm.nextInt(list.size()));
    }

    public static void test() {
        RandomizedCollection set = new RandomizedCollection();
//["RandomizedCollection","insert","insert","insert","insert","insert","remove","remove","remove","remove"]
//[[],                      [4],    [3],        [4],    [2],    [4],    [4],        [3],    [4],    [4]]

        set.insert(0);
        set.remove(0);
        set.insert(-1);
        set.remove(0);
        set.getRandom();
    }
}

