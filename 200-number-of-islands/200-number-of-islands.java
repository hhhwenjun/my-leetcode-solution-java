class Solution {
    private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private char[][] grid;
    private boolean[][] seen;
    
    public int numIslands(char[][] grid) {
        // dfs: find all the directions of 1 and check if they are lands
        this.grid = grid;
        this.seen = new boolean[grid.length][grid[0].length];
        
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (seen[i][j]){
                    continue;
                }
                if (grid[i][j] == '1'){
                    dfs(i, j);
                    count++;
                }
            }
        }
        // if yes, store in a seen array
        // finish the process and count + 1
        return count;
    }
    
    // dfs process
    public void dfs(int i, int j){
        if (i < 0|| j < 0|| i >= grid.length || j >= grid[0].length || seen[i][j] || grid[i][j] == '0'){
            return;
        }
        seen[i][j] = true;
        for (int[] direction : directions){
            dfs(i + direction[0], j + direction[1]);
        }
    }
}