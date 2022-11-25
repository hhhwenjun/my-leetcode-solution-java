class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int totalDuration = 0;
        int currTime = -1;
        for (int time : timeSeries){
            if (currTime < time){
                totalDuration += duration;
                currTime = time + duration - 1;
                continue;
            }
            // merge the time
            int overlap = currTime - time + 1;
            totalDuration -= overlap;
            totalDuration += duration;
            currTime = time + duration - 1;
        }
        return totalDuration;
    }
}