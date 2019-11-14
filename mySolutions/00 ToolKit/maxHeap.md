PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x); // MAX HEAP
// min heap by default

How do you implement buildHeap so it runs in O(n) time?
How do you show that buildHeap runs in O(n) time when implemented correctly?
Why doesn't that same logic work to make heap sort run in O(n) time rather than O(n log n)?
https://stackoverflow.com/questions/9755721/how-can-building-a-heap-be-on-time-complexity



# customized heap
```python
class LargerNumKey(str):
    def __lt__(x, y):
        return x+y > y+x
        
class Solution:
    def largestNumber(self, nums):
        largest_num = ''.join(sorted(map(str, nums), key=LargerNumKey))
        return '0' if largest_num[0] == '0' else largest_num

```
```java
class Solution {
    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
           return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, new LargerNumberComparator());

    }
}
```