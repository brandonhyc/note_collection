class Solution:
    def computeArea(self, A: int, B: int, C: int, D: int, E: int, F: int, G: int, H: int) -> int:
        rec1 = [A, B, C, D]
        rec2 = [E, F, G, H]
            #   x1,y1,x2,y2
        
        # square area
        sq = (rec1[2] - rec1[0]) * (rec1[3] - rec1[1]) + (rec2[2] - rec2[0]) * (rec2[3] - rec2[1])
        # overlap
        left = max(rec1[0], rec2[0])
        right = min(rec1[2], rec2[2])
        
        bot = max(rec1[1], rec2[1])
        top = min(rec1[3], rec2[3])
        
        overlap = (right - left) * (top - bot) if right > left and top > bot else 0 
        
        # print(sq, overlap)
        return sq - overlap 
        