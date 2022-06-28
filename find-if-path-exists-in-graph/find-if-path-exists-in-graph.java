class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // bfs
        // 1. build up neighbor list(adjacency list)
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++){
            adjList.put(i, new ArrayList<Integer>());
        }
        // 2. use edges to fill the list
        for (int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        // 3. find path from source to destination, using queue structure
        Deque<Integer> nodequeue = new ArrayDeque<>();
        boolean[] seen = new boolean[n];
        nodequeue.add(source);
        
        while (!nodequeue.isEmpty()){
            int current = nodequeue.pollLast();
            if (seen[current] == true){
                continue;
            }
            seen[current] = true;
            if (current == destination){
                return true;
            }
            
            List<Integer> neighbors = adjList.get(current);
            for (Integer neighbor : neighbors){
                nodequeue.add(neighbor);
            }
        }
        return false;
    }
}