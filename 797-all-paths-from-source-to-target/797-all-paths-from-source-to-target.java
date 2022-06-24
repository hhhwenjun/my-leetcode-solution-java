class Solution {
    private List<List<Integer>> res;
    private int[][] graph;
    
    // abstract: return all possible paths and return them in any order
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        
        // dfs: the neighbor list is already given
        // length of given array = number of nodes in graph
        
        res = new ArrayList<>();
        int target = graph.length - 1;
        List<Integer> path = new ArrayList<>();
        path.add(0);
        backtracking(0, path, target);
        return res;
    }
    
    public void backtracking(int current, List<Integer> path, int target){
        
        if (current == target){
            res.add(new ArrayList(path));
            return;
        }
        for (int neighbor : graph[current]){
            path.add(neighbor);
            backtracking(neighbor, path, target);
            path.remove(path.size() - 1);
        }
    }
}