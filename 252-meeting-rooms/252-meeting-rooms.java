class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        // use priority queue
        if (intervals.length == 0) return true;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] interval : intervals){
            queue.add(interval);
        }
        int prev = queue.peek()[0];
        while(queue.size() > 0){
            // poll them out and check time
            int[] curr = queue.poll();
            if (prev > curr[0]) return false;
            prev = curr[1];
        }
        return true;
    }
}