class Solution {
    public int longestConsecutive(int[] nums) {
        // map to store the number and index, union-find to group the numbers
        Map<Integer, Integer> numMap = new HashMap<>();
        UnionFind uf = new UnionFind(nums.length);
        for (int i = 0; i < nums.length; i++){
            int curr = nums[i];
            // in case duplicate
            if (numMap.containsKey(curr)) continue;
            // if map has consecutive elements for curr element
            if (numMap.containsKey(curr - 1)){
                uf.union(i, numMap.get(curr - 1));
            }
            if (numMap.containsKey(curr + 1)){
                uf.union(i, numMap.get(curr + 1));
            }
            numMap.put(curr, i);
        }
        return uf.size();
    }
}

class UnionFind {
    private int[] group;
    private int[] rank;
    private int[] size;
    
    public UnionFind(int n){
        group = new int[n];
        rank = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++){
            group[i] = i;
            rank[i] = 1;
            size[i] = 1;
        }
    }
    
    public int find(int node){
        if (node != group[node]){
            group[node] = find(group[node]);
        }
        return group[node];
    }
    
    public int size(){
        int maxsize = 0;
        for (int i = 0; i < size.length; i++){
            maxsize = Math.max(maxsize, size[i]);
        }
        return maxsize;
    }
    
    public boolean union(int i, int j){
        int root1 = find(i);
        int root2 = find(j);
        
        if (root1 == root2){
            // already in same group
            return false;
        }
        if (rank[root1] > rank[root2]){
            group[root2] = group[root1];
            size[root1] += size[root2];
        }
        else if (rank[root2] > rank[root1]){
            group[root1] = group[root2];
            size[root2] += size[root1];
        }
        else {
            group[root1] = group[root2];
            rank[root2]++;
            size[root2] += size[root1];
        }
        return true;
    }
}