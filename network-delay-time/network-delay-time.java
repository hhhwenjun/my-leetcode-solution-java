class Solution {
    Map<Integer, List<int[]>> adjList = new HashMap<>();// key: node, value: pair(nextnode, weighted edge)
    
    public int networkDelayTime(int[][] times, int n, int k) {
        // dfs: directed edges, use it to build adjacency list using map
        for (int[] time : times){
            if (!adjList.containsKey(time[0])){
                adjList.put(time[0], new ArrayList<>());
            }
            adjList.get(time[0]).add(new int[]{time[1], time[2]});
        }
        
        // sort the edges connecting to every node
        for (int node : adjList.keySet()){
            Collections.sort(adjList.get(node), (a, b) -> a[1] - b[1]);
        }
        
        // start from the source node, traverse the adjacency list and + 1 for time in each traversal
        int[] signalReceivedTime = new int[n + 1];
        Arrays.fill(signalReceivedTime, Integer.MAX_VALUE);
        dfs(k, 0, signalReceivedTime);
        
        int answer = Integer.MIN_VALUE;
        
        for (int i = 1; i <= n; i++){
            answer = Math.max(answer, signalReceivedTime[i]);
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    public void dfs(int source, int currTime, int[] seen){
        if (currTime >= seen[source]){
            return;
        }
        seen[source] = currTime;
        
        if (!adjList.containsKey(source)){
            // no next node
            return;
        }
        
        for (int[] nextNode : adjList.get(source)){
            dfs(nextNode[0], currTime + nextNode[1], seen);
        }

    }
}