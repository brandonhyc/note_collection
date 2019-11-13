class Solution:
    def medianSlidingWindow(self, nums: List[int], k: int) -> List[float]:
        maxHeap = []
        minHeap = []
        res = []

        for i in range(len(nums)):
            num = nums[i]
            
            leftMax = -maxHeap[0] if len(maxHeap) > 0 else sys.maxsize
            rightMin = minHeap[0] if len(minHeap) > 0 else -sys.maxsize - 1

            if num < leftMax:
                heapq.heappush(maxHeap, -num)
            else:
                heapq.heappush(minHeap, num)

            self.rebalance(maxHeap, minHeap)

            if len(maxHeap) + len(minHeap) == k:
                if k % 2 == 0:
                    res.append((-maxHeap[0] + minHeap[0]) / 2)
                else:
                    res.append(-maxHeap[0])

                lastElement = nums[i - k + 1]

                if lastElement <= -maxHeap[0]:
                    # print("removing from maxHeap", lastElement, "maxHeap", maxHeap, "minHeap", minHeap)
                    self.remove(maxHeap, -lastElement)
                else:
                    # print("removing from minHeap", lastElement, "maxHeap", maxHeap, "minHeap", minHeap)
                    self.remove(minHeap, lastElement)

            self.rebalance(maxHeap, minHeap)
        
        return res

    
    def remove(self, heap, num):
        # print("inside", heap, num)
        index = heap.index(num)
        heap[index] = heap[-1]
        heap.pop()
        heapq.heapify(heap)
        
        # if index <= len(heap) - 1:
        #     heapq._siftup(heap, index)
        #     heapq._siftdown(heap, 0, index)
    
    def rebalance(self, maxHeap, minHeap):
        if len(maxHeap) < len(minHeap):
            heapq.heappush(maxHeap, -heapq.heappop(minHeap))
        elif len(maxHeap) > len(minHeap) + 1:
            heapq.heappush(minHeap, -heapq.heappop(maxHeap))

