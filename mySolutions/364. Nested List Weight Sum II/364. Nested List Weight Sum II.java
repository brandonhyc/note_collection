/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        
        int result = 0;
        int prev = 0;
        Deque<NestedInteger> deque = new ArrayDeque<>();
        
        for (int i = 0; i < nestedList.size(); i++) {
            deque.push(nestedList.get(i));
        }
        
        while (!deque.isEmpty()) {
            
            int size = deque.size();
            int sumOfLevel = 0;
            
            for (int i = 0; i < size; i++) {
                NestedInteger ni = deque.poll();
                Integer val = ni.getInteger();
                
                // System.out.printf("factor: %d, val: %d\n", factor, val);
                
                if (val != null) {
                    sumOfLevel += val;
                }
                
                List<NestedInteger> list = ni.getList();
                if (list != null) {
                    for (int j = 0; j < list.size(); j++) {
                        deque.offer(list.get(j));
                    }
                }
            }
            
            prev += sumOfLevel;
            result += prev;
        }
        
        
        return result;
    }
}