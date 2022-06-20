class Solution {
    public boolean validTree(int n, int[][] edges) {
       if (edges.length != n - 1) return false;
        
       // make the adjacency list
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++){
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        
        Stack<Integer> stack = new Stack<>();
        Set<Integer> seen = new HashSet<>();
        stack.push(0);
        seen.add(0);
        
        while(!stack.isEmpty()){
            int node = stack.pop();
            for (int neighbour : adjacencyList.get(node)){
                if (seen.contains(neighbour)) continue;
                seen.add(neighbour);
                stack.push(neighbour);
            }
        }
        
        return seen.size() == n;
    }
}