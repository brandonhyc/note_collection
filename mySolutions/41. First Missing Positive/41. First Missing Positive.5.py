class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        
        for unsorted in range(len(nums)):
            while nums[unsorted] != unsorted + 1 and \
            nums[unsorted] - 1 >= 0 and nums[unsorted]  - 1 < len(nums) and \
            nums[nums[unsorted] - 1] != nums[unsorted]:
                self.swap(nums, unsorted, nums[unsorted] - 1)
        
        sorted = 1
        
        for i in range(len(nums)):
            if sorted == nums[i]:
                sorted += 1
        return sorted
        
                
    def swap(self, nums, left, right):
        temp = nums[left]
        nums[left] = nums[right]
        nums[right] = temp