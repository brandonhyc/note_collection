import sys

class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        
        nums.sort()
        closest = None
        
        for i in range(len(nums)):
            
            left = i + 1
            right = len(nums) - 1
            
            while left < right:
                sumOfThree = nums[i] + nums[left] + nums[right]
                
                if closest == None or abs(sumOfThree - target) < abs(closest - target):
                    closest = sumOfThree
                
                if sumOfThree == target:
                    return target
                elif sumOfThree < target:
                    left += 1
                else:
                    right -= 1
        
        return closest            
            
        
        