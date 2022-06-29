class Solution {
    private List<List<Integer>> res;
    int[][] graph;
    
    // find all possible paths: backtracking
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        int target = graph.length - 1;
        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        backtracking(0, target, path);
        return res;
    }
    
    // backtracking process
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