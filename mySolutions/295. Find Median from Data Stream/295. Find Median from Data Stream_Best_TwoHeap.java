    class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    
    public MedianFinder() {
         minHeap = new PriorityQueue<>();
         maxHeap = new PriorityQueue<>(10, Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        
        if (maxHeap.size() == minHeap.size()) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
            maxHeap.add(minHeap.poll());
        }
        else {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        // System.out.printf("%s || %s\n", Arrays.toString(maxHeap.toArray()), Arrays.toString(minHeap.toArray()));

        return (maxHeap.size() > minHeap.size()) ? maxHeap.peek() : (maxHeap.peek() + minHeap.peek()) * 0.5; 
    }
         
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */