class Solution:
        
    def isRectangleOverlap(self, rec1: List[int], rec2: List[int]) -> bool:
        x1 = 0
        x2 = 2
        y1 = 1
        y2 = 3
        
        horizontal = self.isIntervalOverlap([rec1[x1], rec1[x2]], [rec2[x1], rec2[x2]])
        vertical = self.isIntervalOverlap([rec1[y1], rec1[y2]], [rec2[y1], rec2[y2]])
        
        # print("h", horizontal, "v", vertical)
        return horizontal and vertical
    
    def isIntervalOverlap(self, inv1, inv2):
        left = (inv1[0] < inv2[0] and inv2[0] < inv1[1])
        right = (inv2[0] < inv1[0] and inv1[0] < inv2[1])
        aContainsB = inv1[0] <= inv2[0] and inv2[1] <= inv1[1]
        bContainsA = inv2[0] <= inv1[0] and inv1[1] <= inv2[1]
        
        # print("left", left, "right", right, "ab", aContainsB, "ba", bContainsA)
        return left or right or aContainsB or bContainsA