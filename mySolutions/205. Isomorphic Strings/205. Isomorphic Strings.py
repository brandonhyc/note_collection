class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        # s = "egg", t = "add"
        # "ab" "aa"

        mapS = {}
        mapT = {}

        if len(s) != len(t):
          return False
        
        for i in range(len(s)):
          indexS = mapS.get(s[i], -1)
          indexT = mapT.get(t[i], -1)
          
          if indexS != indexT:
            return False
          
          mapS[s[i]] = i
          mapT[t[i]] = i

        return True