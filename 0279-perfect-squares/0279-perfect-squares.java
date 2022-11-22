class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        // use dp method, first learn the squares
        int maxSquareRoot = (int)Math.sqrt(n) + 1;
        int[] squares = new int[maxSquareRoot];
        for (int i = 1; i < maxSquareRoot; i++){
            // calculate root for i
            squares[i] = i * i;
        }
        
        // fill in dp array with squares
        for (int i = 1; i <= n; i++){
            for (int j = 1; j < maxSquareRoot; j++){
                if (i < squares[j]) break;
                dp[i] = Math.min(dp[i], dp[i - squares[j]] + 1);
            }
        }
        return dp[n];
    }
}