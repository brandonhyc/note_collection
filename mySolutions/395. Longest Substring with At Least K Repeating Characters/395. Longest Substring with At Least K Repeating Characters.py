class Solution(object):
    def longestSubstring(self, s, k):
        """
        :type s: str
        :type k: int 
        :rtype: int
        """
        
        maxLength = 0;
        for numUnique in range(1, 26):
            maxLength = max(self.longestSubstringOfRepeatChar(s, k, numUnique), maxLength);
            
        return maxLength;
    
    def longestSubstringOfRepeatChar(self, s, k, numUniqueTarget):
        """
        :type s: str
        :type k: int k repeat
        :type targetCount: int number of different characters 
        :rtype: int
        """
        
        charMap = {};
        start = 0;
        numUnique = 0;
        numNoLessThanK = 0;
        maxLength = 0;
        
        for end in range(len(s)):
            count = charMap.get(s[end], 0) + 1;
            charMap[s[end]] = count;
            if count == 1: numUnique += 1;
            if count == k: numNoLessThanK += 1;
            
            while numUnique > numUniqueTarget:
                charMap[s[start]] -= 1; 
                
                # print ( "start: " , start, "end: " , end, "numUnique: " , numUnique, "numNoLessThanK: " , numNoLessThanK, "numUniqueTarget: "  , numUniqueTarget, charMap);
                
                if charMap[s[start]] == 0: numUnique -= 1;
                if charMap[s[start]] == k - 1: numNoLessThanK -= 1;
                
                start += 1;
            
            if numNoLessThanK == numUniqueTarget:
                maxLength = max(end - start + 1, maxLength);
                
        return maxLength;