import heapq 
class MedianFinder:

    leftHeap = []
    rightHeap = []
    
    def __init__(self):
        """
        initialize your data structure here.
        """

    def addNum(self, num: int) -> None:

        leftHeap = self.leftHeap
        rightHeap = self.rightHeap

        leftLargest = leftHeap[-1] if leftHeap else sys.maxsize
        rightSmallest = rightHeap[0] if rightHeap else -sys.maxsize - 1

        if leftLargest >= num:
            heapq.heappush(leftHeap, num)
        else:
            heapq.heappush(rightHeap, num)

        self.rebalance(leftHeap, rightHeap)

    def rebalance(self, leftHeap, rightHeap):
        if len(leftHeap) < len(rightHeap):
            heapq.heappush(leftHeap, rightHeap.pop(0))
        elif len(leftHeap) > len(rightHeap) + 1:
            heapq.heappush(rightHeap, leftHeap.pop())

    def findMedian(self) -> float:
        leftHeap = self.leftHeap
        rightHeap = self.rightHeap
        
        if len(leftHeap) == len(rightHeap):
            return (leftHeap[-1] + rightHeap[0]) / 2
        
        # total odd number
        return leftHeap[-1]


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()