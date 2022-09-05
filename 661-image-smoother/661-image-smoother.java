class Solution {
    public int[][] imageSmoother(int[][] img) {
        int[][] res = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++){
            for (int j = 0; j < img[0].length; j++){
                res[i][j] = calculateAverage(img, i, j);
            }
        }
        return res;
    }
    
    public int calculateAverage(int[][] img, int i, int j){
        int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {0, 0}, {0, -1}, {-1, 1},
                                         {1, 0}, {0, 1}, {1, 1}, {1, -1}};
        // sum up the value
        int sum = 0;
        int n = 0; // how many elements count
        for (int[] direction : directions){
            int row = i + direction[0];
            int col = j + direction[1];
            if (row < 0 || row >= img.length || col < 0 || col >= img[0].length) continue;
            sum += img[row][col];
            n++;
        }
        return (int) (sum / n);
    }
}