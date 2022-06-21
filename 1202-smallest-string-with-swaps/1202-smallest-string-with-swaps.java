class Solution {
    // swap the number and group them into the same group
    // within the group, construct a new string that meet the requirement
    // union-find (check if the same gorup, how many groups we have)
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());
        // record the pairs and union them into groups
        for (List<Integer> pair : pairs){
            int edge1 = pair.get(0);
            int edge2 = pair.get(1);
            uf.union(edge1, edge2);
        }
        Map<Integer, List<Integer>> groupMap = new HashMap<>();
        
        // group the index of the string in the same group
        for (int index = 0; index < s.length(); index++){
            int root = uf.find(index);
            groupMap.putIfAbsent(root, new ArrayList<>());
            groupMap.get(root).add(index);
        }
        
        // sort the list based on the characters
        char[] resString = new char[s.length()];
        // iterate the elements in each group
        for (List<Integer> group : groupMap.values()){
            List<Character> substringCh = new ArrayList<>();
            for (int index : group){
                substringCh.add(s.charAt(index));
            }
            Collections.sort(substringCh);
            
            for (int i = 0; i < substringCh.size(); i++){
                resString[group.get(i)] = substringCh.get(i);
            }
        }
        return new String(resString);
    }
}

class UnionFind {
    private int[] group;
    private int[] rank;
    
    public UnionFind(int size) {
        this.group = new int[size];
        this.rank = new int[size];
        for (int i = 0; i < size; i++){
            // each person is its own root
            group[i] = i;
            rank[i] = 0;
        }
    }
    
    public int find(int i){
        if (i != group[i]){
            group[i] = find(group[i]);
        }
        return group[i];
    }
    
    // merge two groups
    public boolean union(int ch1, int ch2){
        int root1 = find(ch1);
        int root2 = find(ch2);
        // check if they already in the same group
        if (root1 == root2){
            return false;
        }
        // merge two groups by rank
        if (rank[root1] > rank[root2]){
            group[root2] = group[root1];
        }
        else if (rank[root1] < rank[root2]){
            group[root1] = group[root2];
        }
        else {
            group[root1] = group[root2];
            rank[root2]++;
        }
        return true;
    }
}