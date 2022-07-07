class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int minimumEffortPath(int[][] heights) {
        // binary search
        int left = 0;
        int right = 1000000;
        int result = right;
        while (left <= right){
            int mid = (left + right) / 2;
            // mid is the highest affordable difference
            if (canReachDestination(heights, mid)){
                result = Math.min(result, mid);
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return result;
    }
    
    // use bfs to check if we can reach destination with max absolute difference k
    boolean canReachDestination(int[][] heights, int k){
        int row = heights.length;
        int col = heights[0].length;
        Deque<Cell> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        queue.addLast(new Cell(0, 0));
        visited[0][0] = true;
        while (!queue.isEmpty()){
            Cell curr = queue.removeFirst();
            // if reach the destination
            if (curr.x == row - 1 && curr.y == col - 1){
                return true;
            }
            for (int[] direction : directions){
                int adjacentX = curr.x + direction[0];
                int adjacentY = curr.y + direction[1];
                if (isValidCell(adjacentX, adjacentY, row, col) &&
                   !visited[adjacentX][adjacentY]){
                    int currentDifference = Math.abs(heights[adjacentX][adjacentY] - heights[curr.x][curr.y]);
                    if (currentDifference <= k){
                        visited[adjacentX][adjacentY] = true;
                        queue.addLast(new Cell(adjacentX, adjacentY));
                    }
                }
            }
        }
        return false;
    }
    
    boolean isValidCell(int x, int y, int row, int col){
        return x >= 0 && x <= row - 1 && y >= 0 && y <= col - 1; 
    }
}

class Cell {
    int x;
    int y;
    
    Cell(int x, int y){
        this.x = x;
        this.y = y;
    }
}