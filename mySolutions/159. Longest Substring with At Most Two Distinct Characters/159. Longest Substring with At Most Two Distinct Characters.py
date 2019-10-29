class Solution(object):
    def lengthOfLongestSubstringTwoDistinct(self, s):
        """
        :type s: str
        :rtype: int
        """
        maxLength = 0;
        windowStart = 0;
        charCountMap = {}
        
        for windowEnd in range(len(s)):
            charCountMap[s[windowEnd]] = charCountMap.get(s[windowEnd], 0) + 1;
            
            while len(charCountMap.keys()) > 2:
                # print ("charCountMap: ", charCountMap, "s[windowStart]: ", s[windowStart]);
                count = charCountMap[s[windowStart]] - 1;
                if count == 0:
                    charCountMap.pop(s[windowStart]);
                else:
                    charCountMap[s[windowStart]] = count;
                
                windowStart += 1;
                    
            maxLength = max(windowEnd - windowStart + 1, maxLength);
            
        return maxLength;