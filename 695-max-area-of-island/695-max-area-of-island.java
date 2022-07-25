class Solution {
    int[][] grid;
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        
        // dfs to find each island, for each island, record the area, compare to find max
        // 1. for loop to search each cell, to see if it is the start of a new island
        int length = grid.length;
        int width = grid[0].length;
        int max = 0;
        for (int i = 0; i < length; i++){
            for (int j = 0; j < width; j++){
                if (grid[i][j] == 1){
                    // dfs here to find island area
                    max = Math.max(max, dfs(i, j));
                }
            }
        }
        
        return max;
    }
    
    public int dfs(int i, int j){
        // 2. for each cell we visited, flip it to 0
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        // 3. add 1 to area if the current cell has value 1
        grid[i][j] = 0;
        // find neighbor islands in 4 directions
        return 1 + dfs(i + 1, j) + dfs(i - 1, j) + dfs(i, j - 1) + dfs(i, j + 1);
    }
}