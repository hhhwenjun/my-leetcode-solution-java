class Solution {
    int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    boolean[][] visited;
    char[][] grid;
    
    public int numIslands(char[][] grid) {
        
        // 2. finish the traversal, add 1 to num of islands, move to next cell
        int height = grid.length;
        int width = grid[0].length;
        visited = new boolean[height][width];
        this.grid = grid;
        
        // 1. visited array to record, queue to traverse the matrix (dfs)
        // traverse whole matrix, go through each cells
        int numOfIslands = 0;
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                if (!visited[i][j] && grid[i][j] == '1'){
                    dfs(i, j);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }
    
    public void dfs(int i, int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        if (grid[i][j] == '1'){
            for (int[] direction : directions){
                dfs(i + direction[0], j + direction[1]);
            }
        }
    }
}