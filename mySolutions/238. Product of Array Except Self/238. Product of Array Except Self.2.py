class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        
        res = [1 for i in range(len(nums))]

        product = 1
        # find all product from left
        for i in range(len(nums)):
            # print(nums[i], product, res)
            res[i] = product
            product *= nums[i]

        product = 1
        # find all product from right
        for i in range(len(nums) - 1, -1, -1):
            # print(nums[i], product, res)
            res[i] *= product
            product *= nums[i] 
        
        return res