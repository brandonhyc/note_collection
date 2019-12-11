class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        # move all the nums in larger list to back
        left = m - 1
        right = len(nums1) - 1
        
        while left >= 0:
            nums1[right] = nums1[left]
            left -= 1
            right -= 1
        
        left = n
        right = 0
        start = 0
        
        while left <= len(nums1) - 1 or right <= len(nums2) - 1:
            num1 = nums1[left] if left < len(nums1) else sys.maxsize
            num2 = nums2[right] if right < len(nums2) else sys.maxsize
            
            if num1 < num2:
                nums1[start] = num1
                left += 1
            else:
                nums1[start] = num2
                right += 1
                
            start += 1
            
        return 
