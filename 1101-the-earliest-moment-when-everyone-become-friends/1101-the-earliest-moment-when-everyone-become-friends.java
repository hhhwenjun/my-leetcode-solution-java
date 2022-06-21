class Solution {
    public int earliestAcq(int[][] logs, int n) {
        // union-find to group them together
        // when we lower the group num to only 1 (whole group), that is the earliest moment
        
        // sort the events in time order
        Arrays.sort(logs, new Comparator<int[]>(){
            @Override
            public int compare(int[] log1, int[] log2){
               Integer time1 = log1[0];
               Integer time2 = log2[0];
                return time1.compareTo(time2);
            }
        });
        // initially we have n groups, each of them is a group
        int groupCount = n;
        UnionFind uf = new UnionFind(n);
        
        for (int[] log : logs){
            int timestamp = log[0], person1 = log[1], person2 = log[2];
            
            // we merge the groups 
            if (uf.union(person1, person2)){
                groupCount--;
            }
            
            if (groupCount == 1){
                return timestamp;
            }
        }
        return -1;
    }
}

class UnionFind {
    private int[] group;
    private int[] rank;
    
    public UnionFind(int size){
        // initialize the union find class
        this.group = new int[size];
        this.rank = new int[size];
        for (int person = 0; person < size; person++){
            // each person is its own root
            this.group[person] = person;
            // each person rank 0
            this.rank[person] = 0;
        }
    }
    
    // return the root of group that the person belongs to
    public int find(int person){
        if (person != group[person]){
            group[person] = find(group[person]);
        }
        return group[person];
    }
    
    // merge the two groups, true if the groups are merged
    public boolean union(int a, int b){
        int groupA = this.find(a);
        int groupB = this.find(b);
        
        if (groupA == groupB){
            // they are already in the same group
            return false;
        }
        
        // merge the two groups
        if (rank[groupA] > rank[groupB]){
            group[groupB] = groupA;
        }
        else if (rank[groupA] < rank[groupB]){
            group[groupA] = group[groupB];
        }
        // they have same rank (discrete group)
        else {
            group[groupA] = group[groupB];
            rank[groupB]++;
        }
        return true;
    }
}