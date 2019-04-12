class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        
        i = 0;
        isNegative = False;
        base = 0;
        
        
        # 1. remove all space
        while ((i < len(str)) and str[i] == ' '):
            i = i + 1;
        
        # 2. get the sign
        if ((i < len(str)) and (str[i] == '+' or str[i] == '-')):
            if (str[i] == '+'): 
                isNegative = isNegative;
            if (str[i] == '-'):
                isNegative = not isNegative;
                
            i = i + 1;
                
        # 3. parse
        while ((i < len(str)) and str[i] >= '0' and str[i] <= '9'):
            if (2147483647 / 10 < base or (2147483647 / 10 == base and str[i] > '7')):
                
                if (isNegative): return -2147483648;
                else: return 2147483647;
                
            base  = 10 * base + int(str[i]);
            i = i + 1;
        
        print base;
        
        if(isNegative): return -base;
        
        return base;