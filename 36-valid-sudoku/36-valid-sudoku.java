class Solution {
    // use hashset for the sudoku
    public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        
        Set<Character>[] digitRowSet = new HashSet[len];
        Set<Character>[] digitColSet = new HashSet[len];
        Set<Character>[] digitBlockSet = new HashSet[len];
        
        for (int i = 0; i < len; i++){
            digitRowSet[i] = new HashSet<Character>();
            digitColSet[i] = new HashSet<Character>();
            digitBlockSet[i] = new HashSet<Character>();
        }
        
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                if (board[i][j] == '.') continue;
                
                if (digitRowSet[i].contains(board[i][j])) return false;
                digitRowSet[i].add(board[i][j]);
                
                if (digitColSet[j].contains(board[i][j])) return false;
                digitColSet[j].add(board[i][j]);
                
                int index = (i / 3) * 3 + j / 3;
                if (digitBlockSet[index].contains(board[i][j])) return false;
                digitBlockSet[index].add(board[i][j]);
            }
        }
        return true;
    }
    
}