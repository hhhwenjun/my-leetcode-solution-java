class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ones = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(matrix[i][j] == 1){
                    matrix[i][j] = -1;
                    ones++;
                }
        int x = 0;
        while(ones > 0){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(matrix[i][j] == x){
                         if(isValid(matrix,i+1,j) && matrix[i+1][j] == -1){
                             matrix[i+1][j] = x + 1;
                             ones--;
                         }
                        if(isValid(matrix,i-1,j) && matrix[i-1][j] == -1){
                             matrix[i-1][j] = x + 1;
                             ones--;
                         }
                        if(isValid(matrix,i,j+1) && matrix[i][j+1] == -1){
                             matrix[i][j+1] = x + 1;
                             ones--;
                         }if(isValid(matrix,i,j-1) && matrix[i][j-1] == -1){
                             matrix[i][j-1] = x + 1;
                             ones--;
                         }
                    }
                }
            }
            x++;
        }
        return matrix;
    }
    private boolean isValid(int[][] mat, int i, int j){
        return (i >= 0 && i < mat.length && j >= 0 && j < mat[0].length);
    }
}