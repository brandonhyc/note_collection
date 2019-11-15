class Codec:

    def encode(self, strs):
        """Encodes a list of strings to a single string.
        
        :type strs: List[str]
        :rtype: str
        """
      
        res = ""
        for s in strs:
          length = len(s)
          res = res + str(length) + "/" + s
        
        return res

    def decode(self, s):
        """Decodes a single string to a list of strings.
        
        :type s: str
        :rtype: List[str]
        """
        # "abc", "de", "f", ""
        # -> "3/abc2/de1/f0/"
        
        ""
        i = 0
        res = []
        
        while i <= len(s) - 1:
          length = ""
          word = ""
          while i <= len(s) - 1 and s[i] != "/":
            length += str(s[i])
            i += 1
            
          i += 1
          length = int(length)
          word = s[i : i + length]
          res.append(word)
          i = i + length
        
        return res
        
        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(strs))