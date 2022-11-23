class Solution {
    public boolean checkValid(int[][] matrix) {
        int length = matrix.length;
        
        Set<Integer>[] rowSet = new HashSet[length];
        Set<Integer>[] colSet = new HashSet[length];
        
        for (int j = 0; j < length; j++){
            rowSet[j] = new HashSet<Integer>();
            colSet[j] = new HashSet<Integer>();
        }
        
        for (int i = 0; i < length; i++){
            for (int j = 0; j < length; j++){
                if (rowSet[i].contains(matrix[i][j])) return false;
                rowSet[i].add(matrix[i][j]);
                
                if (colSet[j].contains(matrix[i][j])) return false;
                colSet[j].add(matrix[i][j]);
            }
        }
        return true;
    }
}