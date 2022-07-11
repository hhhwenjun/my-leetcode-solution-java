class Solution {
    // topological sorting + bfs
    Map<Integer, List<Integer>> adjList;
    
    public int minimumSemesters(int n, int[][] relations) {
        // build the adjacency list
        adjList = new HashMap<>();
        int[] indegree = new int[n + 1];
        for (int i = 1; i <= n; i++){
            adjList.put(i, new ArrayList<Integer>());
        }
        for (int[] relation : relations){
            adjList.get(relation[0]).add(relation[1]);
            indegree[relation[1]]++;
        }
        
        // each time we find the indegree == 0 and put it to a queue
        Queue<Integer> order = new ArrayDeque<>();
        int terms = 0;
        for (int i = 1; i <= n; i++){
            if (indegree[i] == 0) order.add(i);
        }
        order.add(0); // add a fake node for terms calculation
        while(!order.isEmpty()){
            int curr = order.poll();
            if (curr == 0){
                terms++;
                if (!order.isEmpty()){
                    order.add(0);
                }
                continue;
            }
            // otherwise it is a tree node
            for (Integer neighbor : adjList.get(curr)){
                indegree[neighbor]--;
                if (indegree[neighbor] == 0){
                    order.add(neighbor);
                }
            }
        }
        int sum = 0;
        for (int num : indegree){
            sum += num;
        }
        return sum == 0 ? terms : -1;
    }
}