class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer>[] rowSet = new HashSet[board.length];
        Set<Integer>[] colSet = new HashSet[board.length];
        Set<Integer>[] blockSet = new HashSet[board.length];
        
        for (int i = 0; i < board.length; i++){
            rowSet[i] = new HashSet<Integer>();
            colSet[i] = new HashSet<Integer>();
            blockSet[i] = new HashSet<Integer>();
        }
        
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == '.') continue;
                int digit = Integer.valueOf(board[i][j]);
                
                if (rowSet[i].contains(digit)) return false;
                rowSet[i].add(digit);
                
                if (colSet[j].contains(digit)) return false;
                colSet[j].add(digit);
                
                int blockIndex = (i / 3) * 3 + j / 3;
                if (blockSet[blockIndex].contains(digit)) return false;
                blockSet[blockIndex].add(digit);
            }
        }
        return true;
    }
}