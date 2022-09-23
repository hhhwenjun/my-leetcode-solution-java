class Solution {
    // dfs: traverse all the nearby oranges
    public int[][] directions = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    int[][] grid;
    Queue<int[]> queue;
    int length;
    int width;
    
    public int orangesRotting(int[][] grid) {
        this.grid = grid;
        int time = 0;
        queue = new LinkedList<>();
        length = grid.length;
        width = grid[0].length;
        
        // find all the rotten oranges in plot
        for (int i = 0; i < length; i++){
            for (int j = 0; j < width; j++){
                if (grid[i][j] == 2){
                    queue.add(new int[]{0, i, j});
                }
            }
        }
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currLevel = current[0];
            time = Math.max(time, currLevel);
            findOther(currLevel, current[1], current[2]);
        }
        
        // find if there is any 1 inside the grid
        for (int i = 0; i < length; i++){
            for (int j = 0; j < width; j++){
                if (grid[i][j] == 1){
                    return -1;
                }
            }
        }
        
        return time;
    }
    
    // dfs find other rotten oranges for next time
    public void findOther(int currLevel, int row, int col){
        for (int[] direction : directions){
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            
            if (nextRow < 0 || nextRow >= length 
                || nextCol < 0 || nextCol >= width 
                || grid[nextRow][nextCol] != 1){
                continue;
            }
            
            grid[nextRow][nextCol] = 2;
            queue.add(new int[]{currLevel + 1, nextRow, nextCol});
        }
    }
}