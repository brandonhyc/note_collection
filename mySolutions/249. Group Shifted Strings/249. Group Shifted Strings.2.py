
# Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
# Output: 
# [
#   ["abc","bcd","xyz"],
#   ["az","ba"],
#   ["acef"],
#   ["a","z"]
# ]

class Solution:
    def groupStrings(self, strings: List[str]) -> List[List[str]]:
        res = []
        map = {}
        for s in strings:
            key = self.getKey(s)
            if key not in map:
                map[key] = []
            map[key].append(s)
        
        for key in map:
            res.append(map[key])

        return res

    def getKey(self, s: str):
        arr = list(s)
        intList = []
        res = ""
        
        for i in range(1, len(arr)):
            diff = ord(arr[i]) - ord(arr[i - 1])
            diff = 26 + diff if diff < 0 else diff

            intList.append(diff)
        
        for num in intList:
          res += str(num)    
        
        return res