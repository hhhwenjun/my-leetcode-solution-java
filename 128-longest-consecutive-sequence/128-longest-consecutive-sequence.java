class Solution {
    // abstract: return longest consecutive sequence in o(n)
    // union-find to group the number that are consecutive |a - b| = 1
    public int longestConsecutive(int[] nums) {
        int length = nums.length;
        UnionFind uf = new UnionFind(length);
        // key: number in nums, value: index of number in nums
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < length; i++){
            if (map.containsKey(nums[i])){
                continue;
            }
            if (map.containsKey(nums[i] - 1)){
                uf.union(i, map.get(nums[i] - 1));
            }
            if (map.containsKey(nums[i] + 1)){
                uf.union(i, map.get(nums[i] + 1));
            }
            map.put(nums[i], i);
        }
        return uf.getMaxSeqSize();
    }
}

// create union-find class
class UnionFind {
    private int[] group;
    private int[] rank;
    
    public UnionFind(int size){
        group = new int[size];
        rank = new int[size];
        
        for (int i = 0; i < size; i++){
            group[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int index){
        if (group[index] != index){
            group[index] = find(group[index]);
        }
        return group[index];
    }
    
    public void union(int index1, int index2){
        int root1 = find(index1);
        int root2 = find(index2);
        
        if (root1 != root2){
            group[root1] = root2;
            rank[root2] += rank[root1];
        }
    }
    
    public int getMaxSeqSize(){
        int maxSize = 0;
        for (int singleRank : rank){
            maxSize = Math.max(maxSize, singleRank);
        }
        return maxSize;
    }
}