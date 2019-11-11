class Solution:
  def reverseWords(self, s: str) -> str:
    trimed = s.strip(" ")
    arr = s.split()
    arr.reverse()

    # print (arr)
    return " ".join(arr).strip(" ")