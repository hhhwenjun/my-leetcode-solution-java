class Solution {
    public int climbStairs(int n) {
        // record for n step, number of ways to the point
        // cumulative process
        int[] dp = new int[n + 1];
        if (n < 2) return 1;
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}