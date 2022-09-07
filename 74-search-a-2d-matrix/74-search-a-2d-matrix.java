class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix.length;
        int width = matrix[0].length;
        
        int row = 0;
        for (int i = 0; i < length; i++){
            if (matrix[i][0] <= target && matrix[i][width - 1] >= target){
                row = i;
                break;
            }
        }
        
        // binary search
        int low = 0, high = width - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if (matrix[row][mid] == target){
                return true;
            }
            else if (matrix[row][mid] < target){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return false;
    }
}