class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean rec1OntheLeftOfrect2 = rec1[2] <= rec2[0]; 
        boolean rec1OntheRightOfrect2 = rec2[2] <= rec1[0]; 
        boolean rec1OntheDownOfrect2 = rec2[1] >= rec1[3]; 
        boolean rec1OntheTopOfrect2 = rec1[1] >= rec2[3]; 
        return !(rec1OntheLeftOfrect2 
            || rec1OntheRightOfrect2 
            || rec1OntheDownOfrect2 
            || rec1OntheTopOfrect2);
    }
}


// The second way
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        boolean overlayHorizontally = Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2]);
        boolean overlayVertically = Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]);
        
        return  (overlayHorizontally && overlayVertically);
    }
}