class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        
        totalTank = 0
        totalCost = 0
        curTank = 0
        start = 0
        
        for i in range(len(gas)):
          totalTank += gas[i]
          totalCost += cost[i]
          
          curTank += gas[i] - cost[i] 
          
          if curTank < 0:
            curTank = 0
            start = i + 1
        
        return start if totalTank >= totalCost else -1
            
        