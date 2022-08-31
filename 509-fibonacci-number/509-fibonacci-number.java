class Solution {
    public int fib(int n) {
        int stepTwoAway = 0, stepOneAway = 1;
        if (n <= 1) return n;
        int curr = 0;
        
        for (int i = 2; i <= n; i++){
            curr = stepOneAway + stepTwoAway;
            stepTwoAway = stepOneAway;
            stepOneAway = curr;
            
        }
        return curr;
    }
}