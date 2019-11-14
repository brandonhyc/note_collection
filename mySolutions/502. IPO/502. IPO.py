import heapq
class Solution:
    def findMaximizedCapital(self, k: int, initialCapital: int, Profits: List[int], Capital: List[int]) -> int:
        
      minHeap = []
      maxHeap = []

      for i in range(len(Capital)):
        heapq.heappush(minHeap, (Capital[i], i))

      totalProfits = initialCapital
      currentCapital = initialCapital

      for i in range(k):
        while len(minHeap) > 0 and currentCapital >= minHeap[0][0]:
          jcapital, j = heapq.heappop(minHeap)
          heapq.heappush(maxHeap, (-Profits[j], j))

        if len(maxHeap) != 0:
          profit, j = heapq.heappop(maxHeap)
          currentCapital += -profit
          totalProfits += -profit

      return totalProfits