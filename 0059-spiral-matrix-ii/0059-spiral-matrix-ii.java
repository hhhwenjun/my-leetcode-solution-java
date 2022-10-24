class Solution {
    public int[][] generateMatrix(int n) {
        int end = n * n;
        int start = 0;
        int[][] res = new int[n][n];
        int leftBound = 0, topBound = 0;
        int rightBound = n - 1, downBound = n - 1;
        while(start < end){
            // left -> right
            int idx = leftBound;
            while(idx <= rightBound){
                res[topBound][idx] = ++start;
                idx++;
            }
            topBound++;
            idx = topBound;
            
            
            // top -> down
            while(idx <= downBound){
                res[idx][rightBound] = ++start;
                idx++;
            }
            rightBound--;
            idx = rightBound;
            
            // right -> left
            while(idx >= leftBound){
                res[downBound][idx] = ++start;
                idx--;
            }
            downBound--;
            idx = downBound;
            
            // down -> top
            while(idx >= topBound){
                res[idx][leftBound] = ++start;
                idx--;
            }
            leftBound++;
            idx = leftBound;
        }
        return res;
    }
}