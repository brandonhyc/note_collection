class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        def swap(nums, left, right):
          temp = nums[left]
          nums[left] = nums[right]
          nums[right] = temp
        
        left = 0
        mid = 0
        right = len(nums) - 1
        
        while mid <= right:
          if nums[mid] == 0:
            swap(nums, left, mid)
            left += 1
            mid += 1
          elif nums[mid] == 1:
            mid += 1
          elif nums[mid] == 2:
            swap(nums, mid, right)
            right -= 1
            