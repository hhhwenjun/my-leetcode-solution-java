class Solution {
    
    private int[][] grid;
    private boolean[][] seen;
    private List<List<int[]>> islandInfo;
    private int[][] directions = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    
    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        islandInfo = new ArrayList<>();
        int count = 0;
        // dfs: find the islands, store islands in lists
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (seen[i][j]){
                    continue;
                }
                if (grid[i][j] == 1){
                    // find a new island
                    List<int[]> island = new ArrayList<>();
                    dfs(i, j, island);
                    if (checkDistinct(island)){
                        count++;
                        islandInfo.add(island);
                    }
                }
            }
        }
        return count;
    }
    
    public void dfs(int i, int j, List<int[]> island){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || seen[i][j]){
            return;
        }
        seen[i][j] = true;
        island.add(new int[]{i, j});
        for (int[] direction : directions){
            dfs(i + direction[0], j + direction[1], island);
        }
    }
    
    // check islands if they are distinct
    public boolean checkDistinct(List<int[]> island){
        if (islandInfo.size() == 0) return true;
        
        for (int i = 0; i < islandInfo.size(); i++){
            List<int[]> islandCompare = islandInfo.get(i);
            if (islandCompare.size() != island.size()){
                continue;
            }
            else {
                boolean same = true;
                int diffX = islandCompare.get(0)[0] - island.get(0)[0];
                int diffY = islandCompare.get(0)[1] - island.get(0)[1];
                for (int j = 0; j < island.size(); j++){
                    int currdiffX = islandCompare.get(j)[0] - island.get(j)[0];
                    int currdiffY = islandCompare.get(j)[1] - island.get(j)[1];
                    if (diffX != currdiffX || diffY != currdiffY){
                        same = false;
                    }
                }
                if (same == true){
                    return false;
                }
            }
        }
        return true;
    }
}