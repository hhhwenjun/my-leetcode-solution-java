class Solution {
    // topological sorting: kahn's algorithm
    // 1. adjacency list, find out the neighbors(dfs)
    // 2. count the in-degree of each node, put node into a queue
    // 3. if the in-degree is reduced to 0, put it into the result
    int numCourses;
    List<List<Integer>> adjList;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // initialization
        this.numCourses = numCourses;
        int[] indegree = new int[numCourses];
        adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList());
        }
        
        // build adjacency list and count the in-degree of node
        for (int[] pre : prerequisites){
            indegree[pre[0]]++;
            // directed graph
            adjList.get(pre[1]).add(pre[0]);
        }
        // kahn's algorithm to reduce the in-degree to 0 for finding order
        boolean[] seen = new boolean[numCourses]; // incase we are in a cycle
        List<Integer> res = new ArrayList<>();
        kahnAlgorithm(res, seen, indegree);
        if (res.size() != numCourses) return new int[0];
        int[] resArray = new int[numCourses];
        for (int i = 0; i < numCourses; i++){
            resArray[i] = res.get(i);
        }
        return resArray;
    }
    
    public void kahnAlgorithm(List<Integer> res, boolean[] seen, int[] indegree){
        for (int i = 0; i < numCourses; i++){
            if (seen[i]){
                continue;
            }
            // the course we can learn right now
            if (indegree[i] == 0){
                res.add(i);
                seen[i] = true;
                List<Integer> neighbors = adjList.get(i);
                for (int neighbor : neighbors){
                    indegree[neighbor]--;
                    kahnAlgorithm(res, seen, indegree);
                }
            }
        }
    }
}