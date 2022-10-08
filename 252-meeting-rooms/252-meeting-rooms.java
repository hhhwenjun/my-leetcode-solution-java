class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int prev = 0;
        for (int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];
            if (start < prev) return false;
            prev = end;
        }
        return true;
    }
}