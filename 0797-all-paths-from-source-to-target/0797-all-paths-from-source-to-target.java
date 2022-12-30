class Solution {
    List<List<Integer>> res;
    int[][] graph;
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<>();
        this.graph = graph;
        List<Integer> path = new ArrayList<>();
        path.add(0);
        backtracking(0, graph.length - 1, path);
        return res;
    }
    
    public void backtracking(int start, int target, List<Integer> path){
        if (start == target){
            res.add(new ArrayList(path));
            return;
        }
        for (int neighbor : graph[start]){
            path.add(neighbor);
            backtracking(neighbor, target, path);
            path.remove(path.size() - 1);
        }
    }
}