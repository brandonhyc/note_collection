class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean rec1OntheLeftOfrect2 = rec1[2] < rec2[0]; 
        boolean rec1OntheRightOfrect2 = rec2[2] < rec1[0]; 
        boolean rec1OntheTopOfrect2 = rec1[1] < rec2[3]; 
        boolean rec1OntheDownOfrect2 = rec2[1] < rec1[3]; 
        return 
    }
}