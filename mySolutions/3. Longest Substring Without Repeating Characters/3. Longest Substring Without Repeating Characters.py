class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        
        maxLength = 0;
        windowStart = 0;
        charMap = {};
        
        for windowEnd in range(len(s)):
            charMap[s[windowEnd]] = charMap.get(s[windowEnd], 0) + 1;
            
            while charMap[s[windowEnd]] > 1:
                charMap[s[windowStart]] = charMap[s[windowStart]] - 1;
                windowStart += 1;
            
            maxLength = max(windowEnd - windowStart + 1, maxLength);
            
        return maxLength;