class Solution {
    // 1. move 4 directions
    int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int EMPTY = Integer.MAX_VALUE;
    int GATE = 0;
    
    public void wallsAndGates(int[][] rooms) {
        
        int row = rooms.length;
        if (row == 0) return;
        int col = rooms[0].length;
        
        // 2. put gate in a queue,
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (rooms[i][j] == GATE){
                    queue.add(new int[]{i, j});
                }
            }
        }
        
        // 3. dfs to mark other cell value
        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];
            for (int[] direction : directions){
                int nextRow = currRow + direction[0];
                int nextCol = currCol + direction[1];
                
                if (nextRow < 0 || nextRow >= row || nextCol < 0 || nextCol >= col
                   || rooms[nextRow][nextCol] != EMPTY){
                    continue;
                }
                rooms[nextRow][nextCol] = rooms[currRow][currCol] + 1;
                queue.add(new int[]{nextRow, nextCol});
            }
        }
    }
}