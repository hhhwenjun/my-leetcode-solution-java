class Solution {
    public int[][] imageSmoother(int[][] M) {
        int rowLast = M.length - 1;
        int colLast = M[0].length - 1;
        
        // Case 1 and 2: Matrix is a single row (including single row AND single column)
        if (rowLast == 0) {     
            if (colLast != 0)  singleRow(M[0], colLast);
        }
        // Case 3: Matrix is a single column with multiple rows
        else if (colLast == 0) {  
            singleCol(M, rowLast);
        }
        // Case 4: Matrix has multiple rows and multiple columns.
        // First sum across the rows, then sum down the columns while taking averages.
        else {                    
            for (int row = 0; row <= rowLast; row++)    // Sum groups across a each row.
                sumRow(M[row], colLast);
            sumCol(M, 0, 4, 6, rowLast);                // Sum first column and average.
            sumCol(M, colLast, 4, 6, rowLast);          // Sum last column and average.
            for (int col = 1; col < colLast; col++)     // Sum middle columns and average.
                sumCol(M, col, 6, 9, rowLast);
        }

        return M;
    }
    

    
    // Calculate the image smoothing averages on a matrix that is a single row.
    // The matrix must have multiple columns.
    private void singleRow(int[] MR, int colLast) {
        int prev = 0;
        int curr = MR[0];
        int next = MR[1];
        MR[0] = (curr + next) / 2;
        for (int col = 1; col < colLast; col++) {
            prev = curr;
            curr = next;
            next = MR[col+1];
            MR[col] = (prev + curr + next) / 3;
        }
        MR[colLast] = (next + curr) / 2;
    }

    

    // Calculate the image smoothing averages on a matrix that is a single column.
    // The matrix must have multiple rows.
    private void singleCol(int[][] M, int rowLast) {
        int prev = 0;
        int curr = M[0][0];
        int next = M[1][0];
        M[0][0] = (curr + next) / 2;
        for (int row = 1; row < rowLast; row++) {
            prev = curr;
            curr = next;
            next = M[row+1][0];
            M[row][0] = (prev + curr + next) / 3;
        }
        M[rowLast][0] = (next + curr) / 2;
    }
    
    
    
    // Sum a single row of the matrix.  Each value of the passed row will be replaced 
    // with the sum of the adjacent row values.  The first and last value on the row 
    // will only become the sum of two values.  The middle values of the row will become 
    // the sum of three values.  No averages are done yet.
    private void sumRow(int[] MR, int colLast) {
        int prev = 0;
        int curr = 0;
        int next = MR[0];
        for (int col = 0; col < colLast; col++) {
            prev = curr;
            curr = next;
            next = MR[col+1];
            MR[col] = prev + curr + next;
        }
        MR[colLast] = next + curr;
    }
        
        
        
    // Sum a single column of the matrix, and calculate the average values for image 
    // smoothing.  The matrix rows must have been previously summed with adjacent row 
    // values.  Since each matrix row has already been summed, each value in the matrix 
    // is already the sum of 2 or 3 values on the row.  While summing a matrix column, 
    // for each value in the column, we sum 2 or 3 values from the matrix, where each 
    // of those values is already the sum of 2 or 3 values on a row.  Each summed 
    // value in this column will then consist of the sum of 2*2=4, 2*3=6, or 3*3=9 values 
    // from the original matrix.  For each sum in this column, we also divide by the 
    // number of values that were summed, to create the smoothed image value.  The number 
    // to divide by to get the average will vary with 4 for matrix corner values, and 6 
    // for matrix edge values, and 9 for matrix values not at any edge, so the divisors 
    // to use are passed as a parameters.  The matrix is required to have multiple rows.
    private void sumCol(int[][] M, int col, int endDiv, int midDiv, int rowLast) {
        int prev = 0;
        int curr = M[0][col];
        int next = M[1][col];
        M[0][col] = (curr + next) / endDiv;
        for (int row = 1; row < rowLast; row++) {
            prev = curr;
            curr = next;
            next = M[row+1][col];
            M[row][col] = (prev + curr + next) / midDiv;
        }
        M[rowLast][col] = (next + curr) / endDiv;
    }
}