class Solution {
    // method: 1. union-find to group all the nodes as groups
    // 2. find the group size of each group
    // 3. res = sum (group size * group size)
    public long countPairs(int n, int[][] edges) {
        // group the node which have edges to connect them
        UnionFind uf = new UnionFind(n);

        for (int[] edge: edges) {
            uf.union(edge[0], edge[1]);
        }
        
        long pairs = 0;
        long remaining = n;
        
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            size[uf.find(i)] ++;
        }
        for (int s: size) {
            if (s == 0) {
                continue;
            }
            remaining -= s;
            pairs += s * remaining;
        }
        
        return pairs;
    }
}

class UnionFind {
    private int[] group;
    private int[] rank;
    
    public UnionFind(int n){
        group = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++){
            group[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int i){
        if (i == group[i]){
            return i;
        }
        return group[i] = find(group[i]);
    }
    
    public boolean union(int node1, int node2){
        int root1 = find(node1);
        int root2 = find(node2);
        
        if (root1 == root2){
            // already in the same group
            return false;
        }
        
        // not in the same group, we merge them together
        if (rank[root1] > rank[root2]){
            group[root2] = group[root1];

        }
        else if (rank[root1] < rank[root2]) {
            group[root1] = group[root2];
        }
        else {
            group[root1] = group[root2];
            rank[root2]++;
        }
        
        return true;
    }
}