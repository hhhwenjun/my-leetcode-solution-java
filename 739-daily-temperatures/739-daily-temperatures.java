class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // two pointers: slow pointer -> current temp, fast pointer -> after ith day
        // 1. make fast and slow pointer
        if (temperatures == null) return new int[0];
        int[] res = new int[temperatures.length];
        int slow = 0, fast = 0;
        
        while (slow < temperatures.length){
            // 2. each time let fast pointer find the day temp > curr temp, slow -> curr
            int currTemp = temperatures[slow];
            fast = slow;
            while(fast < temperatures.length){
                if (temperatures[fast] > temperatures[slow]){
                    break;
                }
                fast++;
            }
            // we cannot find any day warmer
            if (fast == temperatures.length){
                res[slow] = 0;
            }
            else {
                res[slow] = fast - slow;
            }
            // 3. then slow++, fast = slow, point to the same day temp, repeat the process
            slow++;
        }
        return res;
    }
}