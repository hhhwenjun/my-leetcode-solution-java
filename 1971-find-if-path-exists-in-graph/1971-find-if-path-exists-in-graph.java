class Solution {
    // abstract: if there is a valid path from source to destination
    // DFS: 1. Record each vertex and neighbours in list
    // 2. Keep finding the node until traverse all of them
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++){
            nodes.add(new ArrayList<>());
        }
        // neighbour list
        for (int[] edge : edges){
            nodes.get(edge[0]).add(edge[1]);
            nodes.get(edge[1]).add(edge[0]);
        }
        boolean[] seen = new boolean[n];
        
        Stack<Integer> stack = new Stack<>();
        stack.add(source);
        
        while(!stack.isEmpty()){
            int current = stack.pop();
            
            if (current == destination){
                return true;
            }
            if (seen[current]){
                continue;
            }
            seen[current] = true;
            
            // add the neighbours of current to the stack
            for (Integer neighbour : nodes.get(current)){
                stack.add(neighbour);
            }
        }
        return false;
    }
}