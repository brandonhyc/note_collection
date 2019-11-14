class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
      
#         Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
#         Output:
#         [
#           ["ate","eat","tea"],
#           ["nat","tan"],
#           ["bat"]
#         ]
        
        map = {}
        res = []
        for word in strs:
          arr = list(word)
          arr.sort()
          exampleStr = "".join(arr)

          if exampleStr not in map:
            map[exampleStr] = []
          map[exampleStr].append(word)
        
        for key in map:
          res.append(map[key])
          
        return res