class Solution {
    // minimum spanning tree: kruskal's algorithm
    public int minCostConnectPoints(int[][] points) {
        // 1. calculate the edges, sort the edges
        int length = points.length;
        // point, two connected point
        List<int[]> edgeMap = new ArrayList<>();
        for (int i = 0; i < length; i++){
            for (int j = i + 1; j < length; j++){
                int mandis = Math.abs(points[j][0] - points[i][0]) + Math.abs(points[j][1] - points[i][1]);
                edgeMap.add(new int[]{mandis, i, j});
            }
        }
        Collections.sort(edgeMap, (a, b) -> Integer.compare(a[0], b[0]));
        
        // 2. connect the point with edge based on sorting, if create cycle, skip the edge
        // 3. unitl we have n - 1 edges in the graph, we have exactly 1 simple path
        int edgeNum = 0;
        int edgeSum = 0;
        UnionFind uf = new UnionFind(length);
        for (int[] edge : edgeMap){
            int point1 = edge[1];
            int point2 = edge[2];
            if (uf.union(point1, point2)){
                edgeSum += edge[0];
                edgeNum++;
            }
            if (edgeNum == length - 1) break;
        }
        return edgeSum;
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
        }
    }
    
    public int find(int i){
        if (i != group[i]){
            group[i] = find(group[i]);
        }
        return group[i];
    }
    
    public boolean union(int i, int j){
        int root1 = find(i);
        int root2 = find(j);
        
        if (root1 == root2){
            return false;
        }
        
        if (rank[root1] > rank[root2]){
            group[root2] = group[root1];
        }
        else if (rank[root2] > rank[root2]){
            group[root1] = group[root2];
        }
        else {
            group[root1] = group[root2];
            rank[root2]++;
        }
        return true;
    }
}