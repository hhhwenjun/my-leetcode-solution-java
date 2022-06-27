class Solution {
    // dfs: find the neighbor nodes that the node point to
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> direct = new HashMap<>();
        for (int i = 0; i < n; i++){
            direct.put(i, new ArrayList<Integer>());
        }
        for (int[] edge : edges){
            direct.get(edge[0]).add(edge[1]);
        }
        // destination does not have outgoing edge
        if (direct.get(destination).size() != 0) return false;
        return dfs(direct, source, destination, new boolean[n]);
    }
    
    public boolean dfs(Map<Integer, List<Integer>> direct, int source, int destination, boolean[] seen){
        if (source == destination){
            return true;
        }
        // now we have seen the node
        seen[source] = true;
        
        // non-destination should have outgoing edges otherwise we stuck at here
        if (direct.get(source).size() == 0) return false;
        
        // traverse the neighbor destination nodes
        for (int neighbor : direct.get(source)){
            if (seen[neighbor] || !dfs(direct, neighbor, destination, seen)){
                return false;
            }
        }
        
        // backtracking to the before status
        seen[source] = false;
        return true;
    }
}