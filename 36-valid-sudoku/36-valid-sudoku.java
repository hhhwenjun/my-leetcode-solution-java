class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rowSet = new Set[board.length];
        Set<Character>[] colSet = new Set[board.length];
        Set<Character>[] blockSet = new Set[board.length];
        
        for (int i = 0; i < board.length; i++){
            rowSet[i] = new HashSet<Character>();
            colSet[i] = new HashSet<Character>();
            blockSet[i] = new HashSet<Character>();
        }
        
        // loop through the 2D array and put them into the set
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                if (board[i][j] == '.') continue;
                // row set
                if (rowSet[i].contains(board[i][j])) return false;
                rowSet[i].add(board[i][j]);
                
                // col set
                if (colSet[j].contains(board[i][j])) return false;
                colSet[j].add(board[i][j]);
                
                // block set
                int blockIndex = (i / 3) * 3 + j / 3;
                if (blockSet[blockIndex].contains(board[i][j])) return false;
                blockSet[blockIndex].add(board[i][j]);
                
            }
        }
        return true;
    }
}