class HitCounter:

    log = []
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.log = []
        

    def hit(self, timestamp: int) -> None:
        """
        Record a hit.
        @param timestamp - The current timestamp (in seconds granularity).
        """
        self.log.append(timestamp)
        

    def getHits(self, timestamp: int) -> int:
        """
        Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity).
        """
        # get the first number num[i] > t - 300
        if len(self.log) == 0:
          return 0
        
        start = 0
        end = 0
        
        left = 0
        right = len(self.log) - 1
        
        while left < right:
          mid = left + (right - left) // 2
          
          if self.log[mid] > timestamp - 300:
            right = mid
          else:
            left = mid + 1
        
        start = left
        
        left = 0
        right = len(self.log) - 1
        
        while left < right:
          mid = left + (right - left) // 2
          
          if self.log[mid] <= timestamp:
            left = mid + 1
          else:
            right = mid
          
        end = left
        
        print("in time:", timestamp, "hit ", end - start + 1, "start", start, "end", end, self.log)
        if self.log[start] <= timestamp - 300 or self.log[end] > timestamp:
          return 0
        return end - start + 1


# Your HitCounter object will be instantiated and called as such:
# obj = HitCounter()
# obj.hit(timestamp)
# param_2 = obj.getHits(timestamp)