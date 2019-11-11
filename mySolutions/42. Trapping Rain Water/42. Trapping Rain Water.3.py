from collections import deque

class Solution:
    def trap(self, height: List[int]) -> int:
        
        sum = 0
        stack = deque()
        i = 0
        while i <= len(height) - 1:
          rightHi = height[i]
          
          if len(stack) <= 1 or height[stack[-1]] >= rightHi:
            # print ("rightHi",rightHi, "stack[-1]", stack[-1] if stack else 0, stack)
            stack.append(i)
            i += 1
          else:
            midHi = height[stack.pop()]
            left = stack[-1] 
            leftHi = height[left]
            vol = (i - left - 1) * (min(rightHi, leftHi) - midHi)
            # print ("right", i, "left", left, "rightHi", rightHi, "midHi", midHi, "leftHi", leftHi, "vol", vol)
            
            sum += vol if vol >= 0 else 0
      
        return sum 