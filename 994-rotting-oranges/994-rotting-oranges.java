class Solution {
    // bfs: each minute we regard it as a level
    // 4 directions
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int orangesRotting(int[][] grid) {
        Queue<int[]> level = new LinkedList<>();
        // find all rotten orange in the current grid
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 2){
                    level.add(new int[]{0, i, j});
                }
            }
        }
        // use queue to store level-orange, put the neighbors to queue
        int min = 0;
        while (!level.isEmpty()){
            int[] current = level.poll();
            int currentLevel = current[0];
            min = Math.max(min, currentLevel);
            List<int[]> neighbors = findNeighbors(new int[]{current[1], current[2]}, m - 1, n - 1, grid);
            if (neighbors.size() == 0) continue;
            for (int[] neighbor : neighbors){
                level.add(new int[]{currentLevel + 1, neighbor[0], neighbor[1]});
                grid[neighbor[0]][neighbor[1]] = 2;
            }
        }
        // finally check if the grid has 1 or not(if so, return -1)
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return min;
    }
    
    public List<int[]> findNeighbors(int[] current, int maxRow, int maxCol, int[][] grid){
        List<int[]> neighbors = new ArrayList<int[]>();
        int currentRow = current[0];
        int currentCol = current[1];
        
        for (int[] direction : directions){
            int neighborRow = currentRow + direction[0];
            int neighborCol = currentCol + direction[1];
            
            if (neighborRow < 0 || neighborRow > maxRow || neighborCol < 0 
                || neighborCol > maxCol || grid[neighborRow][neighborCol] != 1){
                continue;
            }
            neighbors.add(new int[]{neighborRow, neighborCol});
        }
        return neighbors;
    }
}