class Solution:
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        
        for y in range(len(matrix)):
            find = self.binary_search(matrix[y], target)
            if find:
                return True
            
        return False
    
    def binary_search(self, nums, target):
        
        if len(nums) == 0:
            return False
        
        start = 0
        end = len(nums) - 1
        
        while (start < end):
            mid = start + (end - start) // 2
            if nums[mid] == target:
                return True
            elif nums[mid] < target:
                start = mid + 1
            else:
                end = mid
        return nums[end] == target
                
        