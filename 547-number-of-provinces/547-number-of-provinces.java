class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int count = 0;
        // loop through the nodes and check if they are visited
        for (int i = 0; i < isConnected.length; i++){
            if (visited[i] == 0){
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }
    
    public void dfs(int[][] M, int[] visited, int i){
        // find all the connected node with i
        for (int j = 0; j < M.length; j++){
            if (M[i][j] == 1 && visited[j] == 0){
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
}