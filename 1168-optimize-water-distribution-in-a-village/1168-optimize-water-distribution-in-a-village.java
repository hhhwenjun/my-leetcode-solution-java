class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        // the list for all prices related array
        List<int[]> orderedEdges = new ArrayList<>();
        
        // the cost if we have wells (index 0 is virtual helper) at nodes
        for (int i = 0; i < wells.length; i++){
            orderedEdges.add(new int[]{0, i + 1, wells[i]});
        }
        
        // the cost if we use pipes to connect
        for (int i = 0; i < pipes.length; i++){
            int[] edge = pipes[i];
            orderedEdges.add(edge);
        }
        
        // sort the price list 
        Collections.sort(orderedEdges, (a, b) -> a[2] - b[2]);
        
        // union the house together until they are in the same group(all have water)
        UnionFind uf = new UnionFind(n);
        int cost = 0;
        for (int[] edge : orderedEdges){
            int house1 = edge[0];
            int house2 = edge[1];
            int singleCost = edge[2];
            
            if (uf.union(house1, house2)){
                cost += singleCost;
            }
        }
        return cost;
    }
}

class UnionFind {
    private int[] group;
    private int[] rank;
    
    public UnionFind(int size){
        // container to hold the group id for each member
        // index of member starts from 1, add 1 more to container as node 0
        group = new int[size + 1];
        rank = new int[size + 1];
        for (int i = 0; i < size + 1; i++){
            group[i] = i;
            rank[i] = 0;
        }
    }
    
    public int find(int house){
        if (group[house] != house){
            group[house] = find(group[house]);
        }
        return group[house];
    }
    
    public boolean union(int house1, int house2){
        int root1 = find(house1);
        int root2 = find(house2);
        // already in the same group
        if (root1 == root2){
            return false;
        }
        
        // attach the group of lower rank to the one with higher rank
        if (rank[root1] > rank[root2]){
            group[root2] = group[root1];
        }
        else if (rank[root2] > rank[root1]){
            group[root1] = group[root2];
        }
        else {
            // at the same rank
            group[root1] = group[root2];
            rank[root2]++;
        }
        return true;
    }
}