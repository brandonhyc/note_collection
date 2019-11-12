class Solution:
    def maxArea(self, height: List[int]) -> int:
        
        left = 0
        right = len(height) - 1
        maxVol = 0
        
        while left < right:
          width = right - left
          vol = width * min(height[left], height[right])
          maxVol = max(vol, maxVol)
          
          if height[left] < height[right]:
            left += 1
          else:
            right -= 1
            
        return maxVol
        