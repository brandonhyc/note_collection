
class Solution:
    def longestPalindrome(self, s: str) -> str:
        if len(s) == 0:
            return ""

        maxStr = s[0]
        dp = [[False for i in range(len(s))] for j in range(len(s))]

        for i in range(len(s)):
            dp[i][i] = True
        
        for left in range(len(s) - 1, -1, -1):
            for right in range(left + 1, len(s)):
                if s[left] == s[right]:
                    if left == right or right - left == 1 or dp[left + 1][right - 1] == True:
                        dp[left][right] = True 


                        if right - left + 1 > len(maxStr):
                            maxStr = s[left : right + 1]

        return maxStr

def find_LPS_length(st):
  dp = [[None for i in range(len(st))] for j in range(len(st))]
  return find_LPS_length_recursive(st, 0, len(st) - 1, dp)

def find_LPS_length_recursive(s, left, right, dp):
  if left > right:
    return 0

  # every string with one character is a palindrome
  if left == right:
    return 1

  if dp[left][right] != None:
    return dp[left][right]

  count1 = 0
  count2 = 0
  count3 = 0

  if s[left] == s[right]:
      restLen = right - left  + 1
      calLen = 2 + find_LPS_length_recursive(s, left + 1, right - 1, dp)
      if restLen == calLen: 
        count1 = calLen
          
  count2 = find_LPS_length_recursive(s, left + 1, right, dp)
  count3 = find_LPS_length_recursive(s, left, right - 1, dp)
  
  dp[left][right] = max(count1, count2)
  dp[left][right] = max(count3, dp[left][right])

  return dp[left][right]

def main():
  print(find_LPS_length("abdbca"))
  print(find_LPS_length("cddpd"))
  print(find_LPS_length("pqr"))

main()

def find_LPS_length(st):
  dp = [[None for i in range(len(st))] for j in range(len(st))]

  return find_LPS_length_recursive(st, 0, len(st) - 1, dp)

def find_LPS_length_recursive(s, left, right, dp):
  if left > right:
    return 0

  # every string with one character is a palindrome
  if left == right:
    return 1

  if (dp[left][right] != None):
    return dp[left][right]

  count1 = 0
  count2 = 0
  count3 = 0

  if s[left] == s[right]:
    restLen = right - left  + 1
    calLen = 2 + find_LPS_length_recursive(s, left + 1, right - 1, dp)
    if restLen == calLen: 
        count1 = calLen
          
  count2 = find_LPS_length_recursive(s, left + 1, right, dp)
  count3 = find_LPS_length_recursive(s, left, right - 1, dp)
  
  dp[left][right] = max(count1, count2)
  dp[left][right] = max(count3, dp[left][right])

  return dp[left][right]

def main():
  print(find_LPS_length("abdbca"))
  print(find_LPS_length("cddpd"))
  print(find_LPS_length("pqr"))

main()

class Solution:
    def longestPalindrome(self, s: str) -> str:
        # start from for each step/char we can take 

        maxStr = ""
        for i in range(len(s)):
            left = i
            right = i
            while left >= 0 and right <= len(s) - 1 and s[left] == s[right]:
                if right - left + 1 > len(maxStr):
                    maxStr = s[left : right + 1]
                right += 1
                left -= 1

            left = i
            right = i + 1
            while left >= 0 and right <= len(s) - 1 and s[left] == s[right]:
                if right - left + 1 > len(maxStr):
                    maxStr = s[left : right + 1]
                right += 1
                left -= 1

        return maxStr