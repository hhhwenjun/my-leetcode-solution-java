class Solution {
    public void setZeroes(int[][] matrix) {
        Queue<int[]> zeroQueue = new LinkedList<>();
        int height = matrix.length;
        int width = matrix[0].length;
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                if (matrix[i][j] == 0){
                    zeroQueue.add(new int[]{i, j});
                }
            }
        }
        
        // poll element out of queue, set row/col to zero
        while(!zeroQueue.isEmpty()){
            int[] zero = zeroQueue.poll();
            int row = zero[0];
            int col = zero[1];
            // set the row to 0
            for (int i = 0; i < width; i++){
                matrix[row][i] = 0;
            }
            // set the col to 0
            for (int i = 0; i < height; i++){
                matrix[i][col] = 0;
            }
        }
    }
}