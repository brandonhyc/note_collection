class Solution:
    def fourSum(self, arr: List[int], target: int) -> List[List[int]]:
      quadruplets = []
      # TODO: Write your code here

      arr.sort()

      for one in range(len(arr)):
        # Optimization 2
        if one > 0 and arr[one] == arr[one - 1]:
          continue
        for two in range(one + 1, len(arr)):
          if two > one + 1 and arr[two] == arr[two - 1]:
            continue
          left = two + 1
          right = len(arr) - 1

          while left < right:
            sumOfFour = arr[one] + arr[two] + arr[left] + arr[right]
            combination = [arr[one], arr[two], arr[left], arr[right]]
            if sumOfFour == target:
              left += 1
              right -= 1
              
              quadruplets.append(combination)
              # Optimization 1
              while left < right and arr[left] == arr[left - 1]:
                left += 1
              while left < right and arr[right] == arr[right + 1]:
                right -= 1
                
            elif sumOfFour > target:
              right -= 1
            else:
              left += 1
      return quadruplets
  

