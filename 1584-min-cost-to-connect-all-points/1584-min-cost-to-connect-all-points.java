class Solution {
    public int minCostConnectPoints(int[][] points) {
        int length = points.length;
        
        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>(
        (a, b) -> (a.getKey() - b.getKey()));
        
        boolean[] visited = new boolean[length];
        
        // start with the node 0
        heap.add(new Pair(0, 0));
        int minCost = 0;
        int edges = 0;
        
        while (edges < length){
            Pair<Integer, Integer> top = heap.poll();
            int weight = top.getKey();
            int node = top.getValue();
            
            if (visited[node]){
                continue;
            }
            visited[node] = true;
            minCost += weight;
            edges++;
            
            // traverse the neighbors of this current node
            for (int i = 0; i < length; i++){
                if (!visited[i]){
                    int neighborWeight = Math.abs(points[node][0] - points[i][0]) +
                        Math.abs(points[node][1] - points[i][1]);
                    heap.add(new Pair(neighborWeight, i));
                }
            }
        }
        return minCost;
        
    }
}