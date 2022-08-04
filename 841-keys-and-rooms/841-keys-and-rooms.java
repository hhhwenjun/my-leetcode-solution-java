class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // bfs: visited the adjacent list
        int num = rooms.size();
        int[] visited = new int[num];
        Queue<Integer> queue = new LinkedList<>();
        
        // 1. go to the first room, put it into queue, visited array
        queue.add(0);
        visited[0] = 1;
        
        // 2. add the adjacent rooms to the queue
        while(!queue.isEmpty()){
            int currRoom = queue.poll();
            // visit the rooms with keys (adjacency list)
            for (int room : rooms.get(currRoom)){
                if (visited[room] == 1) continue;
                visited[room] = 1;
                queue.add(room);
            }
        }
        // 3. if the queue is empty, but visited is not all true
        int sum = 0;
        for (int digit : visited) sum += digit;
        return sum == num;
    }
}