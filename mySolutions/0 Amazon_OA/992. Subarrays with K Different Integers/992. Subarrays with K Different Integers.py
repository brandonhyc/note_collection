class Solution:
    def subarraysWithKDistinct(self, nums: List[int], k: int) -> int:
        if len(nums) == 0 or k == 0:
            return 0
        return self.numSubstringAtMostKDistinct(nums, k) - self.numSubstringAtMostKDistinct(nums, k - 1)
        
    def numSubstringAtMostKDistinct(self, s: List[int], k: int) -> int:
        
        if k == 0 or len(s) == 0:
            return 0
        
        charCount = {}
        left = 0
        distinctCount = 0
        res = 0
        
        for right in range(len(s)):
            ch = s[right]
            count = charCount.get(ch, 0);
            if count == 0:
                distinctCount += 1
            charCount[ch] = count + 1
            
            while distinctCount > k:
                ch = s[left]
                count = charCount[ch] - 1
                charCount[ch] = count
                if count == 0:
                    del charCount[ch]
                    distinctCount -= 1
                
                left += 1
            
            res += right - left + 1
            
        return res