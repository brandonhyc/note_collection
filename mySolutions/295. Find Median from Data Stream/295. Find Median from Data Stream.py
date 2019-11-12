import heapq 
class MedianFinder:

    maxHeap = []
    minHeap = []
    
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.maxHeap = []
        self.minHeap = []

    def addNum(self, num: int) -> None:

        maxHeap = self.maxHeap
        minHeap = self.minHeap

        leftLargest = -maxHeap[0] if maxHeap else sys.maxsize
        rightSmallest = minHeap[0] if minHeap else -sys.maxsize - 1

        if leftLargest >= num:
            heapq.heappush(maxHeap, -num)
        else:
            heapq.heappush(minHeap, num)

        self.rebalance(maxHeap, minHeap)

    def rebalance(self, maxHeap, minHeap):
        if len(maxHeap) < len(minHeap):
            heapq.heappush(maxHeap, -heapq.heappop(minHeap))
        elif len(maxHeap) > len(minHeap) + 1:
            heapq.heappush(minHeap, -heapq.heappop(maxHeap))

    def findMedian(self) -> float:
        
        maxHeap = self.maxHeap
        minHeap = self.minHeap
        # print ("maxHeap", maxHeap)
        # print ("minHeap", minHeap)
        
        if len(maxHeap) == len(minHeap):
            return (-maxHeap[0] + minHeap[0]) / 2
        
        # total odd number
        return -maxHeap[0]


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()