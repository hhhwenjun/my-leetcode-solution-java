class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // find if the two rectangle overlap
        int totalLength = ax2 - ax1 + bx2 - bx1;
        int totalHeight = ay2 - ay1 + by2 - by1;
        
        int totalLengthReal = Math.max(Math.max(bx2 - bx1, ax2 - ax1),Math.max(bx2 - ax1, ax2 - bx1));
        int totalHeightReal = Math.max(Math.max(ay2 - ay1, by2 - by1), Math.max(ay2 - by1, by2 - ay1));
        
        if (ax1 == ax2 || bx1 == bx2 || ax2 < bx1 || bx2 < ax1 || by2 < ay1 || ay2 < by1){
            totalLengthReal = totalLength;
            totalHeightReal = totalHeight;
        }
        // calculate the overlap area
        int area = (totalLength - totalLengthReal)*(totalHeight - totalHeightReal);
        
        int totalArea = (ay2 - ay1)*(ax2 - ax1) + (by2 - by1)*(bx2 - bx1) - area;
        return totalArea;
    }
}