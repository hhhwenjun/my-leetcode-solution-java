class Solution {
    public static int GATE = 0;
    public static int WALL = -1;
    public static int INF = Integer.MAX_VALUE;
    public int[][] directions = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    
    public void wallsAndGates(int[][] rooms) {
        // 1. starts from the gate, each time find its adjacent cells (bfs)
        // 2. check the cells, put in a queue
        // 3. each time we add 1 to the distance
        
        Queue<int[]> queue = new LinkedList<>();
        // figure out cells of gate, and put them in queue
        // get the dimension of directions matrix
        int height = rooms.length;
        int width = rooms[0].length;
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                if (rooms[i][j] == GATE){
                    queue.add(new int[]{i, j});
                }
            }
        }
        
        // bfs: while loop to find neighbors and count distance
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];
            for (int[] direction : directions){
                int nextRow = currRow + direction[0];
                int nextCol = currCol + direction[1];
                // if out of range, or is not empty
                if (nextRow < 0 || nextRow >= height || nextCol < 0 || nextCol >= width ||
                   rooms[nextRow][nextCol] != INF){
                    continue;
                }
                rooms[nextRow][nextCol] = rooms[currRow][currCol] + 1;
                queue.add(new int[]{nextRow, nextCol});
            }
        }
    }
}