import heapq, sys
class MedianFinder:

    maxheap = [] # all smaller on the left
    minHeap = [] # all larget on the right
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.maxheap = []
        self.minHeap = []

    def addNum(self, num: int) -> None:
        left = sys.maxsize if len(maxheap) == 0 else maxheap[0]
        right = -sys.maxsize - 1 if len(maxheap) == 0 else minHeap[0]

        # general
        if num <= left:
            heapq.heappush(self.maxheap, num)
        else:
            heapq.heappush(self.minheap, num)

        self.rebalance(maxheap, minheap)

    def findMedian(self) -> float:
        if len(self.maxheap) + len(self.minheap) % 2 == 0:
            return (maxheap[0] + self.minheap[0]) / 2
        return maxheap[0]

    def rebalance(self, maxheap, minheap):
        if len(maxheap) - len(minheap) <= 1:
            return
        heapq.heappush(minheap, heapq.heappop(maxheap))
        


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()