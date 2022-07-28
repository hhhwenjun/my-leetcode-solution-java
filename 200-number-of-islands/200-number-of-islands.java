class Solution {
    int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    char[][] grid;
    
    public int numIslands(char[][] grid) {
        // 1. dfs problem: nested for loop for each cell to check if it is 1
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;
        int num = 0; // number of islands
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '1'){
                    dfs(i, j);
                    num++;
                }
            }
        }
        return num;
    }
    
    public void dfs(int i, int j){
        // if the loc is not valid or is not island
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }
        // 2. visited array(flip to 0) to store if the cell has seen before
        grid[i][j] = '0'; 
        
        // 3. traverse its neighbors
        for (int[] direction : directions){
            dfs(i + direction[0], j + direction[1]);
        }
    }
}