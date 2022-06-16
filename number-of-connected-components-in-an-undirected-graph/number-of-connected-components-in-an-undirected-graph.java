class Solution {
    /**
    * abstract: count connected components
    * similar to merge intervals
    * 1. sort the arrays by edges
    * 2. merge the arrays and find how many distinct groups
    */
    // dfs
    private void dfs(List<Integer>[] adjList, int[] visited, int startNode){
        visited[startNode] = 1;
        for (int i = 0; i < adjList[startNode].size(); i++){
            if (visited[adjList[startNode].get(i)] == 0){
                // find all neighbours' neighbours
                dfs(adjList, visited, adjList[startNode].get(i));
            }
        }
    }
    
    public int countComponents(int n, int[][] edges) {
        int components = 0;
        int[] visited = new int[n];
        
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++){
            adjList[i] = new ArrayList<>();
        }
        // record the edges in the adjacent list
        for (int i = 0; i < edges.length; i++){
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        // loop through the nodes and adjacent nodes
        for (int i = 0; i < n; i++){
            if (visited[i] == 0){
                components++;
                dfs(adjList, visited, i);
            }
        }
        return components;
    }
}