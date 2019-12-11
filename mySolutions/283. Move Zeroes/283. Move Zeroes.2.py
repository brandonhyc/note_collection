class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        def swap(nums, left, right):
          temp = nums[left]
          nums[left] = nums[right]
          nums[right] = temp
        
        left = 0
        right = 0
              
        while right <= len(nums) - 1:
          if nums[right] != 0:
            swap(nums, left, right)
            left += 1
          right += 1