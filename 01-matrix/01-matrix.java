class Solution {
    public int[][] updateMatrix(int[][] mat) {
        // get the dimension info of the matrix
        int length = mat.length;
        int width = mat[0].length;
        boolean[][] visited = new boolean[length][width];
        Queue<int[]> queue = new LinkedList<>();
        
        // bfs: put cell to a queue
        // 1. put all the 0 cells into a queue, mark visited array as true
        for (int i = 0; i < length; i++){
            for (int j = 0; j < width; j++){
                if (mat[i][j] == 0){
                    // dimension: i, j || distance
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        // 2. poll each cell out, traverse 4 directions unvisited array, + 1
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            int currDis = curr[2];
            mat[currX][currY] = currDis;
            
            for (int[] direction : directions){
                int nextX = currX + direction[0];
                int nextY = currY + direction[1];
                if (nextX < 0 || nextX >= length || nextY < 0 || nextY >= width || visited[nextX][nextY]){
                    continue;
                }
                // 3. put them back to queue, repeat the process
                queue.add(new int[]{nextX, nextY, currDis + 1});
                visited[nextX][nextY] = true;
            }
        }
        return mat;
    }
}