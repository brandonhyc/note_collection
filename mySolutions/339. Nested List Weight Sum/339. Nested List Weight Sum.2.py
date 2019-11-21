# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger:
#    def __init__(self, value=None):
#        """
#        If value is not specified, initializes an empty list.
#        Otherwise initializes a single integer equal to value.
#        """
#
#    def isInteger(self):
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        :rtype bool
#        """
#
#    def add(self, elem):
#        """
#        Set this NestedInteger to hold a nested list and adds a nested integer elem to it.
#        :rtype void
#        """
#
#    def setInteger(self, value):
#        """
#        Set this NestedInteger to hold a single integer equal to value.
#        :rtype void
#        """
#
#    def getInteger(self):
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        :rtype int
#        """
#
#    def getList(self):
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        :rtype List[NestedInteger]
#        """
from collections import deque

class Solution:
    def depthSumInverse(self, nestedList: List[NestedInteger]) -> int:
      
      queue = deque()
      
      for element in nestedList:
        queue.append(element)
      
      totalSum = 0
      preLevelSum = 0
      curLevelSum = 0
            
      while queue:
        size = len(queue)
        curLevelSum = 0
        
        for i in range(size):
          element = queue.popleft()
          
          if element.getInteger() != None:
            curLevelSum += element.getInteger()    
          else:
            list = element.getList();
            for nextElement in list:
              queue.append(nextElement)
        preLevelSum += curLevelSum
        totalSum += preLevelSum
        # print("preLevelSum", preLevelSum, "curLevelSum", curLevelSum, "totalSum", totalSum)
        
      return totalSum