class Solution {
    private int[][] matrix;
    private int rows;
    private int columns;
    
    public int[][] imageSmoother(int[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;
        this.columns = matrix[0].length;
        int[][] smoothedImage = new int[rows][columns];
        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < columns; columnIndex++) {
                smoothedImage[rowIndex][columnIndex] = smoothPixel(rowIndex, columnIndex);
            }
        }
        return smoothedImage;
    }
    
    private int smoothPixel(int rowIndex, int columnIndex) {
        int sumOfPixelValues = 0;
        int numberOfNeighbors = 0;
        for (int modifiedRowIndex = Math.max(0, rowIndex - 1); 
             modifiedRowIndex <= Math.min(rows - 1, rowIndex + 1); 
             modifiedRowIndex++) {
            for (int modifiedColumnIndex = Math.max(0, columnIndex - 1); 
                 modifiedColumnIndex <= Math.min(columns - 1, columnIndex + 1); 
                 modifiedColumnIndex++) {
                sumOfPixelValues += matrix[modifiedRowIndex][modifiedColumnIndex];
                numberOfNeighbors++;
            }
        }
        return sumOfPixelValues / numberOfNeighbors;
    }
}