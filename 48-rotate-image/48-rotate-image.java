class Solution {
    public void rotate(int[][] matrix) {
        // use an array to record the elements in matrix
        int length = matrix.length;
        int[] elements = new int[length * length];
        int loc = 0;
        for (int i = 0; i < length; i++){
            for (int j = 0; j < length; j++){
                elements[loc] = matrix[i][j];
                loc++;
            }
        }
        // then put the elements back to the matrix
        loc = 0;
        for (int i = length - 1; i >= 0; i--){
            for (int j = 0; j < length; j++){
                matrix[j][i] = elements[loc];
                loc++;
            }
        }
    }
}