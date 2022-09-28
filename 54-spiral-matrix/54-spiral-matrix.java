class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // if exceed boundary, change the direction, then modify boundary
        // count the number cells as stopping criteria
        int cell = 0;
        int i = 0, j = 0;
        int upboundary = 0, downboundary = matrix.length - 1;
        int rightboundary = matrix[0].length - 1, leftboundary = 0;
        int maxCell = matrix.length * matrix[0].length;
        List<Integer> res = new ArrayList<>();
        while(cell < maxCell){
            // going right
            while(j <= rightboundary && cell < maxCell){
                res.add(matrix[i][j]);
                j++; cell++;
            }
            j--;
            i++;
            upboundary++;
            // going down
            while(i <= downboundary&& cell < maxCell){
                res.add(matrix[i][j]);
                i++; cell++;
            }
            i--;
            j--;
            rightboundary--;
            // going left
            while(j >= leftboundary&& cell < maxCell){
                res.add(matrix[i][j]);
                j--; cell++;
            }
            j++;
            i--;
            downboundary--;
            // going up
            while(i >= upboundary&& cell < maxCell){
                res.add(matrix[i][j]);
                i--; cell++;
            }
            i++;
            j++;
            leftboundary++;
        }
        return res;
    }
}