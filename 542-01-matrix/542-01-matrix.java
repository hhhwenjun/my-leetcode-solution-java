class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int r = mat.length, c = mat[0].length;
        
        int[][] dis = new int[r][c];
        
        for(int i = 0; i < r; i++)
            for(int j = 0; j < c; j++)
                if(mat[i][j] == 0) {
                    explore(mat, dis, dis[i][j], i+1, j);
                    explore(mat, dis, dis[i][j], i-1, j);
                    explore(mat, dis, dis[i][j], i, j+1);
                    explore(mat, dis, dis[i][j], i, j-1);
                }
        
        return dis;
    }
    
    public void explore(int[][] mat, int[][] dis, int wt, int i, int j) {
        if(i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] != 1)
            return;
        
        mat[i][j] = 2;
        
        if(dis[i][j] == 0 || wt+1 < dis[i][j]) {
            dis[i][j] = wt+1;
            explore(mat, dis, wt+1, i+1, j);
            explore(mat, dis, wt+1, i-1, j);
            explore(mat, dis, wt+1, i, j+1);
            explore(mat, dis, wt+1, i, j-1);    
        }
        
        mat[i][j] = 1;
    }
}