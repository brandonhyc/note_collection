import heapq
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        if len(nums) < k or k == 0:
            return []

        res = []
        maxHeap = []
        for i in range(k):
            maxHeap.append(-nums[i])
        heapq.heapify(maxHeap)
        res.append(-maxHeap[0])

        # print(maxHeap)
        for i in range(k, len(nums)):
            maxHeap.remove(-nums[i - k])
            heapq.heapify(maxHeap)
            heapq.heappush(maxHeap, -nums[i])
            res.append(-maxHeap[0])
            # print(maxHeap)

        return res