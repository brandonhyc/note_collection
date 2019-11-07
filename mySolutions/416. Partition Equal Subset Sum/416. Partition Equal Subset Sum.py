import numpy as np
def can_partition(num):
  # TODO: Write your code here
  s = sum(num)
  
  if s % 2 != 0:
    return False

  dp = [[-1 for j in range(0, s // 2 + 1)] for i in range(len(num))]

  can_partition_recursive(dp, num, s // 2, 0)

  print(np.matrix(dp))

  return dp[0][s // 2] == 1

def can_partition_recursive(dp, num, targetSum, index):
  print("index: ", index, "is", num[index], "targetSum", targetSum, "num:", num)
  if dp[index][targetSum] != -1:
    return dp[index][targetSum]

  if targetSum == 0:
    return 1

  if index + 1 >= len(num) or targetSum - num[index] < 0:
    return 0

  pick = can_partition_recursive(dp, num, targetSum - num[index], index + 1) == 1
  notPick = can_partition_recursive(dp, num, targetSum, index + 1) == 1

  if pick or notPick: 
    
    dp[index][targetSum] = 1
  else:
    dp[index][targetSum] = 0

  return dp[index][targetSum]

def main():
  print("Can partition: " + str(can_partition([1, 2, 3, 4])))
  print("Can partition: " + str(can_partition([1, 1, 3, 4, 7])))
  print("Can partition: " + str(can_partition([2, 3, 4, 6])))


main()
