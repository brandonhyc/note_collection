PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x); // MAX HEAP
// min heap by default

How do you implement buildHeap so it runs in O(n) time?
How do you show that buildHeap runs in O(n) time when implemented correctly?
Why doesn't that same logic work to make heap sort run in O(n) time rather than O(n log n)?
https://stackoverflow.com/questions/9755721/how-can-building-a-heap-be-on-time-complexity