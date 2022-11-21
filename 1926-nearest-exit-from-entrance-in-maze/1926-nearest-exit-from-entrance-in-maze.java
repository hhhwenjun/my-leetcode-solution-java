class Solution {
    int[][] directions = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    int length;
    int width;
    
    public int nearestExit(char[][] maze, int[] entrance) {
        length = maze.length;
        width = maze[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        int[] entranceNode = new int[]{entrance[0], entrance[1], 0};
        maze[entrance[0]][entrance[1]] = '+';
        queue.add(entranceNode);
        while(!queue.isEmpty()){
            int[] currNode = queue.poll();
            int currRow = currNode[0];
            int currCol = currNode[1];
            int currDis = currNode[2];
            
            for (int[] direction : directions){
                int nextRow = currRow + direction[0];
                int nextCol = currCol + direction[1];
                // If there exists an unvisited empty neighbor:
                if (0 <= nextRow && nextRow < length && 0 <= nextCol && nextCol < width
                   && maze[nextRow][nextCol] == '.') {
                    
                    // If this empty cell is an exit, return distance + 1.
                    if (nextRow == 0 || nextRow == length - 1 || nextCol == 0 || nextCol == width - 1)
                        return currDis + 1;
                    
                    // Otherwise, add this cell to 'queue' and mark it as visited.
                    maze[nextRow][nextCol] = '+';
                    queue.offer(new int[]{nextRow, nextCol, currDis + 1});
                }
                }
        }
        return -1;
    }
    
}