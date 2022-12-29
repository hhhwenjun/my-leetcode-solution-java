class Solution {
    public int[] getOrder(int[][] tasks) {
        // use min heap for the problem
        PriorityQueue<int[]> nextTask = new PriorityQueue<int[]>((a, b) -> (a[1] != b[1] ? (a[1] - b[1]) : (a[2] - b[2])));

        // store information including the task index
        int idx = 0;
        int[][] taskInfo = new int[tasks.length][3];
        for (int[] task : tasks){
            taskInfo[idx][0] = task[0];
            taskInfo[idx][1] = task[1];
            taskInfo[idx][2] = idx;
            idx++;
        }

        Arrays.sort(taskInfo, (a, b) -> a[0] - b[0]);

        // put task into queue based on the time
        int[] order = new int[tasks.length];
        int orderIdx = 0;
        int time = taskInfo[0][0];
        idx = 0;
        nextTask.add(taskInfo[0]);
        idx++;
        while(idx < tasks.length||!nextTask.isEmpty()){

            if (nextTask.isEmpty() && time < taskInfo[idx][0]) {
                // When the heap is empty, try updating currTime to next task's enqueue time. 
                time = taskInfo[idx][0];
            }

            while (idx < tasks.length && taskInfo[idx][0] <= time){
                nextTask.add(taskInfo[idx]);
                idx++;
            }
            int[] currTask = nextTask.poll();
            time += currTask[1];
            order[orderIdx] = currTask[2];
            orderIdx++;
        }
        return order;
    }
}