class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        // the max speed is the largest pile
        for (int pile : piles){
            max = Math.max(max, pile);
        }
        // binary search
        int min = 1;
        while(min < max){
            int target = (min + max)/2;
            int eathours = 0;
            // calculate curr hours
            for (int pile : piles){
                eathours += Math.ceil((double)pile / target);
            }
            if (eathours > h){
                min = target + 1;
            }
            else {
                max = target;
            }
        }
        return min;
    }
}