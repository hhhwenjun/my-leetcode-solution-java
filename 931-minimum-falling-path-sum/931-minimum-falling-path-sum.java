class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // use dp: for each cell, we record its minimum falling path sum in loop
        for (int i = 1; i < m; i++){
            for (int j = 0; j < n; j++){
                if (j == 0){
                    matrix[i][j] = Math.min(matrix[i][j] + matrix[i - 1][j], matrix[i][j] + matrix[i - 1][j + 1]);
                }
                else if (j == n - 1){
                    matrix[i][j] = Math.min(matrix[i][j] + matrix[i - 1][j], matrix[i][j] + matrix[i - 1][j - 1]);
                }
                else {
                    matrix[i][j] = Math.min(Math.min(matrix[i][j] + matrix[i - 1][j], 
                                               matrix[i][j] + matrix[i - 1][j - 1]), 
                                                matrix[i][j] + matrix[i - 1][j + 1]);
                }
            }
        }
        int minSum = Integer.MAX_VALUE;
        // find the min sum at the bottom of the table
        for (int j = 0; j < n; j++){
            minSum = Math.min(minSum, matrix[m - 1][j]);
        }
        return minSum;
    }
}