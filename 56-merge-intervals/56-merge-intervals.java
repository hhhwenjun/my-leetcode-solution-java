class Solution {
    /**
    * abstract: return non-overlapping intervals
    * 1. sort the intervals by the start
    * 2. merge the intervals by end-start
    */
    public int[][] merge(int[][] intervals) {
        // sort the intervals
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> intervalList = new LinkedList<>();
        
        int min = intervals[0][0];
        int max = intervals[0][1];
        // merge the intervals by end-start
        for (int i = 1; i < intervals.length; i++){
            // current interval
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            // compare with previous start and end
            if (max >= start){
                max = Math.max(max, end);
            }
            else {
                intervalList.add(new int[]{min, max});
                min = start;
                max = end;
            }
        }
        intervalList.add(new int[]{min, max});
        // create the final result int array
        int[][] res = new int[intervalList.size()][2];
        for (int i = 0; i < intervalList.size(); i++){
            res[i] = intervalList.get(i);
        }
        return res;
    }
}