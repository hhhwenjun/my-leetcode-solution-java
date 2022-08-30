class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // best way: find diagonal and check if two diagonal line equals
        // use p1, to find diagonal
        int[][] points = new int[][]{p1, p2, p3, p4};
        int squareLength1 = 0; // can be side length, or diagonal
        int squareLength2 = 0; // can be side length, or diagonal
        
        for (int i = 0; i < 4; i++){
            for (int j = i + 1; j < 4; j++){
                int countLength = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0])
                    + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                if (countLength == 0) return false; // duplicate point
                if (squareLength1 == 0){
                    squareLength1 = countLength;
                }
                else if (squareLength2 == 0 && countLength != squareLength1){
                    squareLength2 = countLength;
                }
                else {
                    // check if current length is either side or diagonal
                    if (countLength != squareLength1 && countLength != squareLength2) return false;
                }
            }
        }
        return true;
    }
}