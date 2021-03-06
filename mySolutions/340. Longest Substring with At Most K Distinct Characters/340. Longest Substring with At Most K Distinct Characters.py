class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        
        if k == 0 or len(s) == 0:
            return 0
        
        charCount = {}
        left = 0
        distinctCount = 0
        maxLen = 0
        
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
            
            maxLen = max(right - left + 1, maxLen)
            
        return maxLen