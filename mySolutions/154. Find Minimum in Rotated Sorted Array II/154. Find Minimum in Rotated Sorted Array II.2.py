class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        left = 0
        right = len(nums) - 1
        top = nums[-1]
        
        while left < right:
            # normal asc order
            if nums[left] < nums[right]:
                return nums[left]
            mid = left + (right - left) // 2
            if nums[mid] < top:
                right = mid
            elif nums[mid] > top:
                left = mid + 1
            else:
                left += 1
            
        return min(nums[left], nums[right])
                