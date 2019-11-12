import sys
class Solution:
    def maximumGap(self, nums: List[int]) -> int:
      if len(nums) <= 1: # edge case 1
        return 0
      start = min(nums)
      end = max(nums)
      if start == end: # edge case 2
        return 0

      gap = max((end - start) // (len(nums) - 1), 1) # edge case 3
      # print("end", end, "start", start, "len(nums) - 1", len(nums) - 1, "gap", gap)
      buckets = {}

      # build buckets
      for num in nums:
        # print("num", num, "start", start, "gap", gap)
        index = (num - start) // gap
        if index not in buckets:
          buckets[index] = [sys.maxsize, -sys.maxsize - 1]
        buckets[index][0] = min(buckets[index][0], num)
        buckets[index][1] = max(buckets[index][1], num)

      maxGap = gap
      lastMax = start

      for index in range(0, (end - start) // gap + 1):
        if index in buckets:
          cur = buckets[index]
          maxGap = max(cur[0] - lastMax, maxGap)
          lastMax = cur[1]
      return maxGap