class Solution {
    int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int[][] image;
    int color;
    int currCol;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // dfs:find all connected neighbors in terms of sr and sc
        this.image = image;
        this.color = color;
        currCol = image[sr][sc];
        dfs(sr, sc);
        return image;
    }
    
    public void dfs(int sr, int sc){
        // if curr cell is out of range or is not connected (0), or we have already seen
        if (sr < 0 || sr >= image.length || sc < 0 || 
            sc >= image[0].length || image[sr][sc] == color || image[sr][sc] != currCol){
            return;
        }
        image[sr][sc] = color;
        for (int[] direction : directions){
            // find all available neighbors for the curr cell
            int row = sr + direction[0];
            int col = sc + direction[1];
            dfs(row, col);
        }
    }
}