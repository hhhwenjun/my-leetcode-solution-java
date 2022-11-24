class Solution {
    public int[][] merge(int[][] intervals) {
        // use a stack to store the intervals, and compare with the latest one
        // 1. sort the intervals by the start
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        // 2. create a list to use it as a stack
        LinkedList<int[]> stack = new LinkedList<>();
        
        for (int[] interval : intervals){
            if (stack.isEmpty() || stack.getLast()[1] < interval[0]){
                stack.add(interval);
                continue;
            }
            // merge the interval
            stack.getLast()[1] = Math.max(stack.getLast()[1], interval[1]);
        }
        int[][] res = new int[stack.size()][2];
        for (int i = 0; i < stack.size(); i++){
            res[i] = stack.get(i);
        }
        return res;
    }
}